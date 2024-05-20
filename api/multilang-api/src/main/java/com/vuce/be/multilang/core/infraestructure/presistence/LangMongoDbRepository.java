package com.vuce.be.multilang.core.infraestructure.presistence;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.core.domain.repositories.ILangRepository;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class LangMongoDbRepository implements ILangRepository {

    MongoTemplate mongoTemplate;

    public LangMongoDbRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Cacheable(value = "lang", key = "#name")
    public Lang findByName(String name) throws NotFoundError {
        Query query = new Query(Criteria
                .where("name")
                .is(name)
        );

        query.fields().exclude("_id");
        query.fields().exclude("name");

        Lang result = mongoTemplate.findOne(query, Lang.class, "langs");

        if(result == null) throw new NotFoundError("Lang not found");

        return result;
    }

    @Override
    @Caching(
            put = {
                    @CachePut(value = "lang", key = "#name")
            },
            evict = {@CacheEvict(value = "lang", allEntries = true)}
    )
    public void save(Lang body, String name) {
        Query query = new Query(Criteria
                .where("name")
                .is(name)
        );

        Lang result = mongoTemplate.findOne(query, Lang.class, "langs");

        if(body.get("name") != null) {
            body.remove("name");
        }

        body.put("name", name);

        if(result == null) {
            mongoTemplate.save(body, "langs");
            return;
        }

        mongoTemplate.findAndRemove(query, Lang.class, "langs");
        mongoTemplate.save(body, "langs");
    }
}
