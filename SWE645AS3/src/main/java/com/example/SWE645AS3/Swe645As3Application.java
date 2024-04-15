package com.example.SWE645AS3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Swe645As3Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Swe645As3Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Swe645As3Application.class, args);
    }
}




//package com.example.SWE645AS3;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Swe645As3Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Swe645As3Application.class, args);
//	}
//
//}
