package com.Hiroo.talentSourcing.util;

import lombok.Getter;

@Getter
public enum ErrorTypes {
    USER_NOT_FOUND(101, "No user with the given email"),
    USER_ALREADY_EXISTS(100,"User already exists with the given email");

    private final int code;
    private final String message;

    ErrorTypes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
