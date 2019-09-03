package com.accenture.huaweigroup.config;

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

@Configuration
@EnableSwagger2
public class SwagerConfig {
    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 配置到项目的controller包
                .apis(RequestHandlerSelectors.basePackage("com.accenture.huaweigroup.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * @Description: 构建api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("自走棋服务器API文档")
                .description("自走棋游戏网页端服务所需调用API综述文档")
                .contact(new Contact("HUAWEI GROUP", "none", "none"))
                // 定义版本号
                .version("版本号:.0.0.2").build();
    }
}
