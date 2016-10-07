package com.dariawan.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Desson Ariawan <teodesson@yahoo.com>
 */
@Configuration
@EnableSwagger2
public class MySpringSwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            // .paths(PathSelectors.regex("/api/.*"))
            .build()
            .apiInfo(apiInfo());
    }
    
    //    @Bean
    //    public UiConfiguration uiConfig() {
    //      return UiConfiguration.DEFAULT;
    //    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Swagger POC REST APIs",
            "Swagger POC REST APIs",
            "V1.0",
            "Swagger POC TOS",
            "somebodyemail@company.com",
            "Swagger POC License",
            "Swagger POC License URL"
        );
        return apiInfo;
    }
}
