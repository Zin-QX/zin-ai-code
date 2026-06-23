package com.zinqx.zinaicodeuser;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.zinqx.zinaicodeuser.mapper")
@ComponentScan("com.zinqx")
@EnableDubbo
public class ZinAiCodeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZinAiCodeUserApplication.class, args);
    }

}

