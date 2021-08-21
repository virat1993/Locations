package com.general.Locations.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerCongfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.general.Locations.controller"))
               // .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/*"));
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Postgres gis rest samples",
                "Created CURD operations API's for postgres gis database.",
                "Alpha",
                "Terms of service",
                new Contact("Virat Singh Chauhan", "", "virat1993@gmail.com"),
                "License of API", "API license URL");
    }
}
