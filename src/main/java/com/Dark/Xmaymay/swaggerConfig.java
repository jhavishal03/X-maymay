package com.Dark.Xmaymay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Vishal Jha", "https://affectionate-mestorf-d160b8.netlify.app/", "vishaljha.12rpvv@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "X-MayMay", "Application API description", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());



    @Bean
    @ApiIgnore
   public Docket api(){
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(DEFAULT_API_INFO)
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.any())
               .build();

   }

}
