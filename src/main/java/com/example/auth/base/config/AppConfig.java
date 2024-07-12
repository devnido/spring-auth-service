package com.example.auth.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mongodb.properties")
public class AppConfig {

}
