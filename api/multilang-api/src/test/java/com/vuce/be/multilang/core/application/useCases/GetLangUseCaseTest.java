package com.vuce.be.multilang.core.application.useCases;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;
import com.vuce.be.multilang.shared.infraestructure.UnitTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class GetLangUseCaseTest extends UnitTestCase {

    @Test
    void get() throws NotFoundError {
        GetLangUseCase langUseCase = new GetLangUseCase(repository);
        langUseCase.get("es");
        verify(repository).findByName("es");
    }
}