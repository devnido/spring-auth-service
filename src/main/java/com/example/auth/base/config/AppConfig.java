package com.example.auth.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource("classpath:mongodb.properties"),
    @PropertySource("classpath:jwt.properties")
})
public class AppConfig {

}
