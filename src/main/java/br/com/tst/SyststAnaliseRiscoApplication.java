package br.com.tst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.tst.domain"})
public class SyststAnaliseRiscoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyststAnaliseRiscoApplication.class, args);
    }
}
