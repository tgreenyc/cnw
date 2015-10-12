package io.pivotal.spring.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloSpringBootApplication {
    
    @Value("${greeting}")
    String greeting;
    
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
    
    @RequestMapping("/")
    public String hello() {
        return String.format("%s World!", greeting);
    }
}