package com.example.kafkapub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * CORS 해결을 위한 mapping
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedOrigins("*")
                .allowedMethods("GET","POST", "HEAD", "PUT","DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("Content-Type","X-Requested-With","accept", "Origin",
                        "Access-Control-Request-Method","submissionid")
                .exposedHeaders("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
                        "Access-Control-Allow-Credentials","message")
                .allowCredentials(true).maxAge(3600L);
    }
}
