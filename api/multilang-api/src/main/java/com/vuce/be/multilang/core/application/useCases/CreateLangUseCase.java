package com.vuce.be.multilang.core.application.useCases;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import com.vuce.be.multilang.shared.application.annotations.ApplicationLayerService;
import com.vuce.be.multilang.shared.domain.logger.ILogger;

@ApplicationLayerService
public class CreateLangUseCase {

    private final ILangRepository langRepository;
    private final ILogger logger;

    public CreateLangUseCase(ILangRepository langRepository, ILogger logger){
        this.langRepository = langRepository;
        this.logger = logger;
    }

    public void set(Lang body, String name){
        logger.info("Creating lang: " + name, this.getClass());
        this.langRepository.save(body, name);
    }
}
