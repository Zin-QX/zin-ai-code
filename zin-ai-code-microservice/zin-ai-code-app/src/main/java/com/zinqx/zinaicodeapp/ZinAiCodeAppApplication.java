package com.zinqx.zinaicodeapp;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.zinqx.zinaicodeapp.mapper")
@EnableDubbo
@EnableCaching
public class ZinAiCodeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZinAiCodeAppApplication.class, args);
    }

}


