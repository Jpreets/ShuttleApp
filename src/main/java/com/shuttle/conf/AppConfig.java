package com.shuttle.conf;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan({"com.shuttle"})
@Import({MongoConfig.class})
@PropertySource("classpath:EmailConfig.properties")
public class AppConfig {

    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private Integer port;
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;

    
    @Bean
    public JavaMailSender getmailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(username);
        sender.setPassword(password);
        sender.setJavaMailProperties(properties);
        return sender;

    }
}
