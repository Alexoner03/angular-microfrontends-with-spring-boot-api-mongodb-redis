package com.vuce.be.multilang.core.application.useCases;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import com.vuce.be.multilang.shared.application.annotations.ApplicationLayerService;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;

@ApplicationLayerService
public class GetLangUseCase {

    private final ILangRepository langRepository;

    public GetLangUseCase(ILangRepository langRepository) {
        this.langRepository = langRepository;
    }

    public Lang get(String name) throws NotFoundError {
        return this.langRepository.findByName(name);
    }
}
