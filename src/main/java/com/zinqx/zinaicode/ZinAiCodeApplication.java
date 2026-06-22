package com.zinqx.zinaicode;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.zinqx.zinaicode.mapper")
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
public class ZinAiCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZinAiCodeApplication.class, args);
    }

}
