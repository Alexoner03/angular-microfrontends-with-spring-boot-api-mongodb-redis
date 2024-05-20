package com.vuce.be.multilang.shared.application.errors;

import com.vuce.be.multilang.shared.domain.errors.DomainError;

public class PayloadError extends DomainError {
    public PayloadError(String message) {
        super(message);
    }
}
