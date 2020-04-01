package com.example.yangpeng.utils;

import org.springframework.beans.factory.annotation.Value;
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
public class Swagger2Config {

    //是否关闭swagger 在配置文件中设置
    @Value("${swagger.enable}")
    private boolean swaggerShow;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.yunwudata.controller"))
                .paths(PathSelectors.any())//测试环境使用any() //线上环境使用none
                //.paths(PathSelectors.none())//如果是线上环境，添加路径过滤，设置为全部都不符合 可以不用
                .build();
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("yangpeng.net")
                //创建人
                .contact(new Contact("Adonispeng/杨鹏", "", "yp4444@126.com"))
                //版本号
                .version("1.0")
                //描述
                .description("")
                .build();
    }
}