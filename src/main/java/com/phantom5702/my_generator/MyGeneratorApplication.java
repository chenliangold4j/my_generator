package com.phantom5702.my_generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.phantom5702.my_generator.dao")
public class MyGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGeneratorApplication.class, args);
    }

}
