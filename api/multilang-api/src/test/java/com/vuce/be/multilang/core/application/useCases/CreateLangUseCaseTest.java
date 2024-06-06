package com.vuce.be.multilang.core.application.useCases;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.shared.infraestructure.UnitTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CreateLangUseCaseTest extends UnitTestCase {

    @Test
    void should_save_a_lang() {
        CreateLangUseCase langUseCase = new CreateLangUseCase(repository, logger);
        Lang lang = new Lang();
        String name = "es";
        lang.put("Hello", "world");
        langUseCase.set(lang, name);
        verify(repository).save(lang, name);
    }
}