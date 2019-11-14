package com.improving.bootcamp.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookClient {

    private final RestTemplate restTemplate;

    public BookClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Volumes volumeSearch(String query ){
      return restTemplate
              .getForObject("https://www.googleapis.com/books/v1/volumes?q={query}",
                      Volumes.class,
                      uriVariables(query));

    }

    private Map<String, String> uriVariables(String query){
        Map<String, String> variables = new HashMap<>();
        variables.put("query", query);
        return variables;
    }

}
