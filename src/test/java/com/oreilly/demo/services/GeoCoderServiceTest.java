package com.oreilly.demo.services;

import com.oreilly.demo.json.Site;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GeoCoderServiceTest {

   private final Logger logger = LoggerFactory.getLogger(GeoCoderServiceTest.class);

   @Autowired
   private GeoCoderService service;

   @Test
   void getLatLangWithoutStreet() {

      Site site = service.getLatLang("Boston", "MA");
      logger.info(site.toString());
      assertAll(
            () -> assertEquals(42.36, site.getLatitude(), 0.01),
            () -> assertEquals(-71.06, site.getLangitue(), 0.01)
      );
   }

   @Test
   void getLatLangeWithStreet() {

      Site site = service.getLatLang("1600 Ampithetre Parkway", "Mountain View", "CA");
      logger.info(site.toString());
      assertAll(
            () -> assertEquals(37.42, site.getLatitude(), 0.01),
            () -> assertEquals(-122.08, site.getLangitue(), 0.01)
      );

   }
}
