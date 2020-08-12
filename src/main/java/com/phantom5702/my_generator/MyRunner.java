package com.phantom5702.my_generator;

import com.phantom5702.my_generator.service.GeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    GeneratorService generatorService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("runner ");
        String tableName = "innovate_studio";
        byte[] bytes = generatorService.generatorCode(new String[]{tableName});
        IOUtils.write(bytes, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.zip"));
    }
}
