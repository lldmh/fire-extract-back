package com.ncut.fireextractback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author dmh
 * @Date 2023/7/24 11:09
 * @Version 1.0
 * @introduce  文档信息配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ncut.fireextractback.Controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        //http://localhost:8989/swagger-ui.html
        Contact contact = new Contact("dmh", "http://www.my.com", "my@my.com");
        return new ApiInfoBuilder()
                .title("文档标题")
                .description("文档描述")
                .contact(contact)   // 联系方式
                .version("1.1.0")  // 版本
                .build();
    }
}
