package com.java.vk.vk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application1 {
    static final Logger log =
            LoggerFactory.getLogger(Application1.class);
    public static void main(String[] args) {

        try {
            FileWriter fstream1 = new FileWriter("/Users/nikolajvereschagin/Desktop/vk/src/main/resources/app.log");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {log.error("Error in file cleaning: {}",e.getMessage());}

        log.info("Before Starting application");
        SpringApplication.run(Application1.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);


    }
}
