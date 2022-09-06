package br.com.ada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CostumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerApplication.class, args);
    }

}
