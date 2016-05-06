package com.shuttle.conf;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.util.Arrays;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@PropertySources(@PropertySource("classpath:MongoConfig.properties"))
@EnableMongoRepositories(basePackages = "com.shuttle.repository")
public class MongoConfig {

    @Value("${mongodb.user}")
    private String mongoUser;

    @Value("${mongodb.password}")
    private String mongoPassword;

    @Value("${mongodb.db}")
    private String mongoDb;

    @Value("${mongodb.serverip}")
    private String mongoServerIP;

    /**
     * To Set Default Logging Level to WARN
     */
    public static final Logger root = (Logger) LoggerFactory
            .getLogger(Logger.ROOT_LOGGER_NAME);

    static {
        root.setLevel(Level.WARN);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

//        MongoCredential credential = MongoCredential.
//                createScramSha1Credential(mongoUser, mongoDb, mongoPassword.toCharArray());
        ServerAddress serverAddress = new ServerAddress(mongoServerIP);

       // MongoClient mongo = new MongoClient(serverAddress, Arrays.asList(credential));
        MongoClient mongo = new MongoClient(serverAddress);

        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, mongoDb);

        return simpleMongoDbFactory;

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

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
