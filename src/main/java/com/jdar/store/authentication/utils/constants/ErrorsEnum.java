package com.jdar.store.authentication.utils.constants;

import lombok.Getter;

@Getter
public enum ErrorsEnum {

    ERROR_JWT_INVALID_TOKEN("TO_001", "Token invalid"),
    ERROR_JWT_VALIDATING_TOKEN("T0_002", "Error decoding and validating token"),
    ERROR_GENERATING_JWT_TOKEN("T0_003", "Error building JWT token"),
    ERROR_LOG_IN_USER("LU_001", "Unexpected error in User login. Please retry later"),
    ERROR_LOG_IN_UNAUTHORIZED("LU_002", "User or password are incorrect");

    private final String errorCode;
    private final String errorDescription;

    ErrorsEnum(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
