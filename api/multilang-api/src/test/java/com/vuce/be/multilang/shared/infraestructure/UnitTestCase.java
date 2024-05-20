package com.vuce.be.multilang.shared.infraestructure;


import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public abstract class UnitTestCase extends GenericTestCase {

    protected ILangRepository repository;

    @BeforeEach
    protected void setUp() {
        this.repository = mock(ILangRepository.class);
    }
}
