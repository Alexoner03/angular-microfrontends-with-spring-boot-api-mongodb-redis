package com.vuce.be.multilang.core.infraestructure.controllers;

import com.vuce.be.multilang.core.application.useCases.CreateLangUseCase;
import com.vuce.be.multilang.core.application.useCases.GetLangUseCase;
import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LangController {

    private final GetLangUseCase getLangUseCase;
    private final CreateLangUseCase createLangUseCase;

    public LangController(GetLangUseCase getLangUseCase, CreateLangUseCase createLangUseCase) {
        this.getLangUseCase = getLangUseCase;
        this.createLangUseCase = createLangUseCase;
    }

    @GetMapping("/lang/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Lang> getLang(@PathVariable("name") String name) throws NotFoundError {
        return ResponseEntity.ok(getLangUseCase.get(name));
    }

    @PostMapping("/lang/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> setLang(@RequestBody Lang body, @PathVariable String name){
        createLangUseCase.set(body, name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
