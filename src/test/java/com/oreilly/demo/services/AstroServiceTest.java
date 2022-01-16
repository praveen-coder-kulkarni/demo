package com.oreilly.demo.services;

import com.oreilly.demo.json.Assignment;
import com.oreilly.demo.json.AstroResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class AstroServiceTest {

   @Autowired
   private AstroService service;

   @Test
   public void getAstronauts() {

      AstroResult result = service.getAstronauts();
      int number = result.getNumber();
      List<Assignment> people = result.getPeople();
      System.out.println("There are " + number + " people in space");
      result.getPeople().forEach(System.out::println);
      assertAll(
            () -> assertTrue(number >= 0),
            () -> assertEquals(number, people.size())
      );
   }
}
