package com.ncut.fireextractback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ncut.fireextractback.mapper")   //需要去扫描mapper所在位置
@EnableSwagger2     //开启swagger2接口文档
public class FireExtractBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireExtractBackApplication.class, args);
    }

}
