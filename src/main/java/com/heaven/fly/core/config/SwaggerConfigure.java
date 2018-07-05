package com.heaven.fly.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 23:05
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.heaven.fly.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mySpringBoot 使用Swagger2构建RESTful APIs")
                .description("fly api 详细说明")
                .termsOfServiceUrl("heavenisme.aliyun.com")
                .contact(new Contact("fly", "heavenisme.aliyun.com", null))
                .version("1.0")
                .build();
    }

}
