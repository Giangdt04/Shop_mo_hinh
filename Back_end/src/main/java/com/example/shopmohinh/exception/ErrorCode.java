package com.example.shopmohinh.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
//    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_KEY(1001,"Invalid message key",HttpStatus.UNAUTHORIZED),

    USER_EXISTED(1002,"User existed",HttpStatus.BAD_REQUEST),

    USER_NOT_EXISTED(1003,"User not existed",HttpStatus.NOT_FOUND),

    UNAUTHENTICATED(1004,"UnAuthenticated",HttpStatus.BAD_REQUEST),

    USERNAME_INVALID(1005,"username must be at least 3 characters",HttpStatus.BAD_REQUEST),

    PASSWORD_INVALID(1006,"password must be at least 5 characters",HttpStatus.BAD_REQUEST),

    UNAUTHORIZED(1007,"you do not have permission",HttpStatus.FORBIDDEN),

    TOKEN_INVALID(1008,"Token invalid",HttpStatus.BAD_REQUEST),

    ROLE_NOT_FOUND(1009,"Role not found",HttpStatus.NOT_FOUND),

    SIZE_NOT_EXISTED(1010,"Size not existed",HttpStatus.NOT_FOUND),

    MATERIAL_NOT_EXISTED(404_001,"Material not existed",HttpStatus.NOT_FOUND),

    AVATAR_URL_INVALID(400_001,"Avatar invalid",HttpStatus.BAD_REQUEST),

    INVALID_FILE_TYPE(400_002,"file invalid",HttpStatus.BAD_REQUEST),

    FILE_UPLOAD_FAILED(400_003,"upload fail",HttpStatus.BAD_REQUEST),

    EMAIL_SENDING_FAILED(400_004,"send email fail",HttpStatus.BAD_REQUEST),

    INVALID_VERIFICATION_CODE(400_005,"invalid verification code",HttpStatus.BAD_REQUEST),

    VERIFICATION_TOKEN_NOT_FOUND(400_006,"verification code not found",HttpStatus.BAD_REQUEST)

    ;

    private int code;

    private String message;

    private HttpStatusCode statusCode;
}
