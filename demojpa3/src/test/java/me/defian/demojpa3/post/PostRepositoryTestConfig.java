package me.defian.demojpa3.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public PostListener postListener(){
        return new PostListener();
    }
}
