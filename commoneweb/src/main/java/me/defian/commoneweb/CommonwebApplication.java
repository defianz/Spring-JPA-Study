package me.defian.commoneweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware")
class CommonewebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonewebApplication.class, args);
    }

}
