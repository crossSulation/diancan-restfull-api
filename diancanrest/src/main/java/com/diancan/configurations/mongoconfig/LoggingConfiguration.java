package com.diancan.configurations.mongoconfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class LoggingConfiguration extends AbstractMongoConfiguration {

    @Value("${mongoConfig.loggingDB.host}")
    private String mongohost;

    @Value("${mongoConfig.loggingDB.port}")
    private int port;

    @Value("${mongoConfig.loggingDB.name}")
    private String dbName;

    @Override
    protected String getDatabaseName() {
        return  dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongohost,port);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws  Exception {
        return new MongoTemplate(mongoDbFactory(),mappingMongoConverter());
    }
}
