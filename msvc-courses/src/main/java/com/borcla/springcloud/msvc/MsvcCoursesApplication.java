package com.borcla.springcloud.msvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsvcCoursesApplication {

    public static void main(String[] args) {
        System.out.println(java.util.TimeZone.getDefault().getID());
        SpringApplication.run(MsvcCoursesApplication.class, args);
    }

}
