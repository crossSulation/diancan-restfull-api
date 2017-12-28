package com.diancan.configurations.mongoconfig;

import org.springframework.stereotype.Component;

@Component("mongoConfig")
public class MongoConfig {

    private String fileDBName;

    private String loggingDBName;

    private String port;

    private String userName;

    private String password;

    private boolean useCluster;
}
