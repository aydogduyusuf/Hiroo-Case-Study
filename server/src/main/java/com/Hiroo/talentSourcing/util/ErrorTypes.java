package com.Hiroo.talentSourcing.util;

import lombok.Getter;

@Getter
public enum ErrorTypes {
    CANDIDATE_NOT_FOUND(101, "No candidate with the given id"),
    CANDIDATE_ALREADY_EXISTS(100,"Candidate already exists with the given email");

    private final int code;
    private final String message;

    ErrorTypes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
