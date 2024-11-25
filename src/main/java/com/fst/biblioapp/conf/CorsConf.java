package com.fst.biblioapp.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CorsConfig addCorsMappings method called");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
