package com.myblog.blogapp.config;

import io.swagger.v3.oas.models.security.Scopes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration

public class swaggerConfig {

    public static  final  String AUTHORIZATION_HEADER="Authorization";
    private ApiKey apiKeys(){
        return new ApiKey("JWT","AUTHORIZATION_HEADER","header");
    }

    private List<SecurityContext> securityContexts(){
        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
    }

    private List<SecurityReference> sf(){
        AuthorizationScope scope=new springfox.documentation.service.AuthorizationScope("global","accessEverything");
       return List.of(new SecurityReference("JWT", new AuthorizationScope[]{scope}));
    }
@Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getinfo())
                .securityContexts(securityContexts())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo getinfo() {
        return  new ApiInfo("Bloging application:backend course","This is developed by gangadhar","1.0","terms of service",
                new Contact("Gangadhar","https://gangadhar.com","ganguli1433@gmail.com"),"Licence of APIs","API licence url", Collections.emptyList());
    }
}