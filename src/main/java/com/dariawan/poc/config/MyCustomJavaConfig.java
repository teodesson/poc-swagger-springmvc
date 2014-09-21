package com.dariawan.poc.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.paths.RelativeSwaggerPathProvider;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Desson Ariawan <teodesson@yahoo.com>
 */
//@Configuration
//@EnableWebMvc
@EnableSwagger
//@ComponentScan("com.dariawan.poc.controller")
public class MyCustomJavaConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean //Don't forget the @Bean annotation
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns("/.*");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Dariawan API Title",
                "Dariawan API Description",
                "Dariawan API terms of service",
                "Dariawan API Contact Email",
                "Dariawan API Licence Type",
                "Dariawan API License URL"
        );
        return apiInfo;
    }

    @Bean
    public SwaggerPathProvider relativeSwaggerPathProvider() {
        return new ApiRelativeSwaggerPathProvider();
    }

    private class ApiRelativeSwaggerPathProvider extends SwaggerPathProvider {

        public static final String ROOT = "/poc-swagger-springmvc";

        @Override
        protected String applicationPath() {
            return ROOT;
        }

        @Override
        protected String getDocumentationPath() {
            return ROOT + "/api-docs";
        }
    }
}
