package com.vuce.be.multilang.core.infraestructure.controllers;

import com.vuce.be.multilang.shared.infraestructure.EndToEndTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LangControllerTest extends EndToEndTestCase {

    @Test
    void save_a_lang() throws Exception {
        assertRequestWithBody("POST", "/lang/es", "{\"Hello\":\"world\"}", 201);
    }

    @Test
    void return_a_saved_lang() throws Exception {
        assertRequestWithBody("POST", "/lang/es", "{\"Hello\":\"world\"}", 201);
        assertResponse("/lang/es", 200, "{\"Hello\":\"world\"}");
    }

    @Test
    void return_a_not_found_lang() throws Exception {
        assertResponse("/lang/fr", 404, "{\"message\":\"Lang not found\", \"status\":\"NOT_FOUND\"}");
    }
}