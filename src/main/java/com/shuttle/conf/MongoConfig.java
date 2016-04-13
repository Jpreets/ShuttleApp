package com.shuttle.conf;

import com.mongodb.DBCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
public class MongoConfig {
//@Autowired
//MongoOperations mongoOperation;

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {

        MongoCredential credential = MongoCredential.createScramSha1Credential("root", "shuttle", "mindfire".toCharArray());
        ServerAddress serverAddress = new ServerAddress("127.0.0.1");

        MongoClient mongo = new MongoClient(serverAddress, Arrays.asList(credential));

        SimpleMongoDbFactory simpleMongoDbFactory
                = new SimpleMongoDbFactory(mongo, "shuttle"//,
                );

        return simpleMongoDbFactory;

    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        // show error, should off on production to speed up performance
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;

    }

//        @Bean
//    public DBCollection users() {
//        return mongoOperation.getCollection("users");
//    }
}
