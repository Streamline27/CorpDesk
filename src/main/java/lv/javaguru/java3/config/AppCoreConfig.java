package lv.javaguru.java3.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"lv.javaguru.java3"})
public class AppCoreConfig {

        public static void main(String[] args) throws Exception {
                SpringApplication.run(AppCoreConfig.class, args);
                }

}
