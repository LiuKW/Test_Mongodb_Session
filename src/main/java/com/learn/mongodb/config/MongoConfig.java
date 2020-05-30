package com.learn.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@Configuration
////@EnableMongoRepositories(basePackages = "com.learn.mongodb")
//public class MongoConfig extends AbstractMongoConfiguration {
//
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;
//
//    @Value("${spring.data.mongodb.uri}")
//    private String mongoConnectionURI;
//
//
//    @Bean
//    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
//        return new MongoTransactionManager(dbFactory);
//    }
//
//
//    @Override
//    protected String getDatabaseName() {
//        return databaseName;
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new MongoClient(new MongoClientURI(mongoConnectionURI));
//    }
//}



@Configuration
public class MongoConfig {
    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory factory){
        return new MongoTransactionManager(factory);
    }
}