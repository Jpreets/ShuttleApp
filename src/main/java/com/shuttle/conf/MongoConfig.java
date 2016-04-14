package com.shuttle.conf;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@PropertySource("classpath:MongoConfig.properties")
public class MongoConfig {

    @Value("${mongodb.user}")
    private String mongoUser;
    @Value("${mongodb.password}")
    private String mongoPassword;
    @Value("${mongodb.db}")
    private String mongoDb;
    @Value("${mongodb.serverip}")
    private String mongoServerIP;

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {

        MongoCredential credential = MongoCredential.
                createScramSha1Credential(mongoUser, mongoDb, mongoPassword.toCharArray());

        ServerAddress serverAddress = new ServerAddress(mongoServerIP);

        MongoClient mongo = new MongoClient(serverAddress, Arrays.asList(credential));

        SimpleMongoDbFactory simpleMongoDbFactory =
                new SimpleMongoDbFactory(mongo, mongoDb);

        return simpleMongoDbFactory;

    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        // show error, should off on production to speed up performance
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
