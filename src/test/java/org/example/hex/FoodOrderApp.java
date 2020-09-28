package org.example.hex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class FoodOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(FoodOrderApp.class, args);
    }

    @Slf4j
    @Component
    static class BeanInfo implements CommandLineRunner {

        @Autowired
        private ApplicationContext applicationContext;

        @Override
        public void run(String... args) throws Exception {
            log.info("Beans:");
            for (String beanName : applicationContext.getBeanDefinitionNames()) {
                log.info("->{}", beanName);
            }
            log.info("--------------");
        }
    }
}
