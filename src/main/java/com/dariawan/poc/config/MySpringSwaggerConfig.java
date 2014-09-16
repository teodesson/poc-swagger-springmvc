package com.dariawan.poc.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.configuration.SwaggerModelsConfiguration;
import com.mangofactory.swagger.paths.AbsoluteSwaggerPathProvider;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Desson Ariawan <teodesson@yahoo.com>
 */
@Configuration
//@ComponentScan(basePackages = {"com.mangofactory.swagger.controllers"})
@Import(SwaggerModelsConfiguration.class)
public class MySpringSwaggerConfig extends SpringSwaggerConfig {

    @Bean
    @Override
    public SwaggerPathProvider defaultSwaggerPathProvider() {
        return new AbsoluteSwaggerPathProvider();
    }
}
