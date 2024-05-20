package com.vuce.be.multilang.shared.application.errors;

import com.vuce.be.multilang.shared.domain.errors.DomainError;

public class NotFoundError extends DomainError {
    public NotFoundError(String message) {
        super(message);
    }
}
