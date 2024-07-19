package com.example.auth.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
@PropertySource("classpath:mongodb.properties")
public class MongoConfig {

}
