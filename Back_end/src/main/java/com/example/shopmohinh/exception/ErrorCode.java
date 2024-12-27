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

    ;

    private int code;

    private String message;

    private HttpStatusCode statusCode;
}
