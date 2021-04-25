package com.huberyzhao.activemq.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo()).select()
                        .apis(RequestHandlerSelectors.basePackage("com.huberyzhao"))
                        .build();
    }

    /**
     * 访问地址：{host}/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("activemq-demo接口")
                .description("activemq-demo")
                .version("1.0")
                .build();
    }
}
