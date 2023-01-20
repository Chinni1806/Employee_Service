package com.accenture.Employee_Service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Autowired
    Environment evn;
    @Override
    public String getConnectionString() {
        return evn.getProperty("app.db.bootstrap-hosts");
    }

    @Override
    public String getUserName() {
        return evn.getProperty("app.db.username");
    }

    @Override
    public String getPassword() {
        return evn.getProperty("app.db.password");
    }

    @Override
    public String getBucketName() {
        return evn.getProperty("app.db.bucketName");
    }
}
