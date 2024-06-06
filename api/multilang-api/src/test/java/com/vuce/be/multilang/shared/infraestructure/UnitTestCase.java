package com.vuce.be.multilang.shared.infraestructure;


import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import com.vuce.be.multilang.shared.domain.logger.ILogger;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public abstract class UnitTestCase extends GenericTestCase {

    protected ILangRepository repository;
    protected ILogger logger;

    @BeforeEach
    protected void setUp() {
        this.repository = mock(ILangRepository.class);
        this.logger = mock(ILogger.class);
    }
}
