package com.biopark.challenge.apirestconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.biopark.challenge"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    public ApiInfo metaInfo() {
        return new ApiInfo(
            "BackEnd Challenge API REST",
            "API REST Solicitada para o desafio da Wealth Systems.",
            "1.0",
            "Terms of Service",
            new Contact("Norton Wagner Martins", "", "norton_martins@hotmail.com"),
            "MIT License",
            "https://choosealicense.com/licenses/mit/", new ArrayList<>()
        );
    }
}
