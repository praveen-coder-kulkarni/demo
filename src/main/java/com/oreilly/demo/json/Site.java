package com.oreilly.demo.json;

public class Site {

   private Integer id;
   private final String address;
   private final double latitude;
   private final double langitue;

   public Site(String address, double latitude, double langitue) {

      this.address = address;
      this.latitude = latitude;
      this.langitue = langitue;
   }

   public String getAddress() {

      return address;
   }

   public double getLatitude() {

      return latitude;
   }

   public double getLangitue() {

      return langitue;
   }

   @Override
   public String toString() {

      return "Site{" + "id=" + id + ", address='" + address + '\'' + ", latitude=" + latitude + ", langitue=" + langitue
            + '}';
   }
}
