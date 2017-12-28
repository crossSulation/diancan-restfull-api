package com.diancan.configurations.mongoconfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class LoggingConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.url}")
    private String mongoAddr;

    @Override
    protected String getDatabaseName() {
        return "logging";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoAddr);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws  Exception {
        return new MongoTemplate(mongoDbFactory(),mappingMongoConverter());
    }
}
