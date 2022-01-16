package com.oreilly.demo;

import com.oreilly.demo.json.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

   public static void main(String[] args) {

      SpringApplication.run(DemoApplication.class, args);
   }

   @Bean
   public Greeting defaultGreeting(){
      return new Greeting("Hello, World!");
   }

}
