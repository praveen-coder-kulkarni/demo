package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {

   private final RestTemplate template;
   private final WebClient webClient;

   @Autowired
   public AstroService(RestTemplateBuilder rtBuilder, WebClient.Builder wcBuilder) {

      template = rtBuilder.build();
      webClient = wcBuilder.baseUrl("http://api.open-notify.org").build();
   }

   public AstroResult getAstronautsRT() {

      String url = "http://api.open-notify.org/astros.json";
      return template.getForObject(url, AstroResult.class);

   }

   public AstroResult getAstronautsWC() {

      return webClient.get()
                      .uri("/astros.json")
                      .accept(MediaType.APPLICATION_JSON)
                      .retrieve()
                      .bodyToMono(AstroResult.class)
                      .block(Duration.ofSeconds(2));
   }
}
