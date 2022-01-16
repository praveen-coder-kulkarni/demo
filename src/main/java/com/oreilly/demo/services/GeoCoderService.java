package com.oreilly.demo.services;

import com.oreilly.demo.json.Response;
import com.oreilly.demo.json.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeoCoderService {

   private final WebClient client;

   private final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

   @Autowired
   public GeoCoderService(WebClient.Builder wcBuilder) {

      this.client = wcBuilder.baseUrl("https://maps.googleapis.com").build();
   }

   public Site getLatLang(String... address) {
      String encoded = Stream.of(address)
            .map(s -> URLEncoder.encode(s, StandardCharsets.UTF_8))
            .collect(Collectors.joining(","));
      String path = "/maps/api/geocode/json";
      Response response = client.get()
            .uri(uriBuilder -> uriBuilder.path(path)
               .queryParam("address", encoded)
               .queryParam("key", KEY)
               .build()
            )
            .retrieve()
            .bodyToMono(Response.class)
            .block(Duration.ofSeconds(2));
      return new Site(response.getResults().get(0).getFormattedAddress(),
               response.getResults().get(0).getGeometry().getLocation().getLat(),
               response.getResults().get(0).getGeometry().getLocation().getLng()
            );
   }
}
