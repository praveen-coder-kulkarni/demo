package com.oreilly.demo;

import com.oreilly.demo.json.Greeting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootTest
class DemoApplicationTests {

   @Autowired
   private ApplicationContext context;

   @Test
   void contextLoads() {
      assertNotNull(context);
      System.out.println(context.getClass().getName());
      System.out.println("There are " + context.getBeanDefinitionCount() +
            " number of beans in application context");
      Arrays.stream(context.getBeanDefinitionNames())
            .forEach(System.out::println);
   }

   @Test @Disabled
   void noGreetingInAppCtx() {
      assertThrows(NoSuchBeanDefinitionException.class,
            () -> context.getBean(Greeting.class));
   }

   @Test
   void getBeanTwice(){
      Greeting greeting1 = context.getBean(Greeting.class);
      Greeting greeting2 = context.getBean(Greeting.class);
      greeting1.setMessage("What, up?");
      System.out.println(greeting2.getMessage());
      assertSame(greeting1, greeting2);
   }

}
