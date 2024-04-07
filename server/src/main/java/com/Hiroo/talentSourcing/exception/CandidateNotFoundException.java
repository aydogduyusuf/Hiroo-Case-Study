package com.Hiroo.talentSourcing.exception;


import com.Hiroo.talentSourcing.util.ApiException;
import com.Hiroo.talentSourcing.util.ErrorTypes;


public class CandidateNotFoundException extends ApiException {
    public CandidateNotFoundException() {
        super(ErrorTypes.CANDIDATE_NOT_FOUND.getCode(), ErrorTypes.CANDIDATE_NOT_FOUND.getMessage());
    }
}
