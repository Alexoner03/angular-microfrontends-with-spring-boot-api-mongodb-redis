package com.vuce.be.multilang.shared.infraestructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, List<HashMap<String, Object>>> redisListTechnicalSheets(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, List<HashMap<String, Object>>> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}

