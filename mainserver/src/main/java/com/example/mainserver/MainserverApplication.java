package com.example.mainserver;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class MainserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainserverApplication.class, args);
    }
   @Bean
    Queue queue(){
        return new Queue("2hu0.mail.welcome");
    }

}
