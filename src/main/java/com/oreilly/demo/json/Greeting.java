package com.oreilly.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

   private final String message;

   public Greeting(@JsonProperty("message") String message) {

      this.message = message;
   }

   public String getMessage() {

      return message;
   }

   @Override
   public String toString() {

      return "Greeting{" + "message='" + message + '\'' + '}';
   }
}
