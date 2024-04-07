package com.Hiroo.talentSourcing.exception;

import com.Hiroo.talentSourcing.util.ApiException;
import com.Hiroo.talentSourcing.util.ErrorTypes;

public class InteractionNotFoundException extends ApiException {
    public InteractionNotFoundException() {
        super(ErrorTypes.INTERACTION_NOT_FOUND.getCode(), ErrorTypes.INTERACTION_NOT_FOUND.getMessage());
    }
}
