package me.defian.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemospringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemospringdataApplication.class, args);
    }

}
