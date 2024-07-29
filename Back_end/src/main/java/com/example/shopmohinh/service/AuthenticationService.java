package com.example.shopmohinh.service;

import com.example.shopmohinh.dto.request.AuthenticationRequest;
import com.example.shopmohinh.dto.request.IntrospectRequest;
import com.example.shopmohinh.dto.response.AuthenticationResponse;
import com.example.shopmohinh.dto.response.IntrospectResponse;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.exception.AppException;
import com.example.shopmohinh.exception.ErrorCode;
import com.example.shopmohinh.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class AuthenticationService {

    UserRepository userRepository;

    //@NonFinal để ko tiêm cái này vào contructor
    @NonFinal
    protected static final String SIGNER_KEY =
            "jyl4q4MPE5mpdiRnlDFpjWb3Vowfj52sYT9YHRSOsQlLIhznImeyGZZFUnz8ghEl";

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();

        //Vì đã mã hóa bằng thuật toán MAC -> verifier bằng MAC
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        //lấy ra thời gian hiệu lực của token
        Date expitTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        //trả về true or false
        var verifired = signedJWT.verify(verifier);

        //kiểm tra xem token còn hiệu lực hay ko
        return IntrospectResponse.builder()
                .valid(verifired && expitTime.after(new Date()))
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        var user  = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPass(), user.getPass());
        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        var token = generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String generateToken(User user){
        //header chứa nội dung của thuật toán mà ta sd
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //Nội dung của token
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("giangdtph40542.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        //token hết hạn sau 1 giờ
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                //có thể tạo thêm claim custom
                .claim("user ID",user.getId())
                //role của user
                .claim("scope",buildScope(user))
                .build();

        //convert jwtset -> jsonset và Payload nhận
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        //kí token MACSigner(thuật toán kí token)

        try {

            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            //chuyển sang kiểu String
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException();
        }
    }

    private String buildScope(User user){
        StringJoiner stringJoiner = new StringJoiner(" ");

        if(!CollectionUtils.isEmpty(user.getRoles())){
            user.getRoles().forEach(role ->{
                stringJoiner.add("ROLE_" + role.getName());
                if(!CollectionUtils.isEmpty(role.getPermissions())){
                    role.getPermissions()
                            .forEach(permission ->
                            stringJoiner.add(permission.getName()));
                }
            });
        }
        return stringJoiner.toString();
    }
}
