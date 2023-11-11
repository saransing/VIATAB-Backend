package com.example.viatabbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ViatabBackendApplication {


    @RequestMapping("/")
    public String index() {
        return "VIA TAB Application, React not implemented yet";
    }
    public static void main(String[] args) {
        SpringApplication.run(ViatabBackendApplication.class, args);
    }

}
