package com.vuce.be.multilang.core.infraestructure.repositories;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;
import com.vuce.be.multilang.shared.infraestructure.IntegrationTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class LangMongoDbRepositoryTest extends IntegrationTestCase {

    @Test
    void should_save_a_lang_on_mongodb() {
        Lang lang = new Lang();
        lang.put("Hello", "world");
        mongoDbRepository.save(lang, "es");
    }

    @Test
    void should_return_a_saved_lang() throws NotFoundError {
        Lang lang = new Lang();
        lang.put("Hello", "world");
        mongoDbRepository.save(lang, "es");
        lang.remove("name");
        lang.remove("_id");
        assertEquals(lang, mongoDbRepository.findByName("es"));
    }

    @Test
    void should_not_return_a_lang() throws NotFoundError {
        assertThrows(NotFoundError.class, () -> mongoDbRepository.findByName("fr"));
    }
}