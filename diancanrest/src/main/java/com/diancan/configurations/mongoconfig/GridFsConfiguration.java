package com.diancan.configurations.mongoconfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class GridFsConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.url}")
    private String mongoAddr;

    @Override
    protected String getDatabaseName() {
        return "diancan-GridFS";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoAddr);
    }
}
