package com.diancan.configurations.mongoconfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.diancan.respositorys.mongo")
public class DiancanMongoConfiguartion extends AbstractMongoConfiguration {

    @Value("${mongoConfig.businessDB.host}")
    private String mongohost;

    @Value("${mongoConfig.businessDB.port}")
    private int port;

    @Value("${mongoConfig.businessDB.name}")
    private String dbName;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongohost,port);
    }
}
