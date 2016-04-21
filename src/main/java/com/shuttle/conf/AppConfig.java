package com.shuttle.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.shuttle" })
@Import({ MongoConfig.class })
public class AppConfig {

}