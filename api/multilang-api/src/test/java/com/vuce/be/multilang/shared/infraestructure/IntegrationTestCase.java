package com.vuce.be.multilang.shared.infraestructure;

import com.vuce.be.multilang.MultilangApiApplication;
import com.vuce.be.multilang.core.infraestructure.repositories.LangMongoDbRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MultilangApiApplication.class)
@SpringBootTest
public abstract class IntegrationTestCase extends GenericTestCase {
    @Autowired
    protected LangMongoDbRepository mongoDbRepository;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @BeforeEach
    protected void setUp() {
        mongoTemplate.dropCollection("lang");
    }
}
