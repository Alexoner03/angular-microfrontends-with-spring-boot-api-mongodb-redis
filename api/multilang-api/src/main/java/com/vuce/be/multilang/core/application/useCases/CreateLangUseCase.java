package com.vuce.be.multilang.core.application.useCases;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import com.vuce.be.multilang.shared.application.annotations.ApplicationLayerService;

@ApplicationLayerService
public class CreateLangUseCase {

    private final ILangRepository langRepository;

    public CreateLangUseCase(ILangRepository langRepository){
        this.langRepository = langRepository;
    }

    public void set(Lang body, String name){
        this.langRepository.save(body, name);
    }
}
