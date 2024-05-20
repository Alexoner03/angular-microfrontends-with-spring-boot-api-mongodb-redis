package com.vuce.be.multilang;

import com.vuce.be.multilang.shared.application.annotations.ApplicationLayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ApplicationLayerService.class})
)
@EnableMongoRepositories
@EnableCaching
public class MultilangApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultilangApiApplication.class, args);
    }
}
