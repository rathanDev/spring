package org.jana.stockservice.resource;

import org.jana.stockservice.model.StockQuote;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockResourceTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGet() {
        System.out.println("Get stock");
//        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:8300/rest/db", HttpMethod.GET,
//                null, new ParameterizedTypeReference<List<String>>() {
//                });
//        System.out.println("quoteResponse = " + quoteResponse);

        ResponseEntity<String> call= restTemplate.getForEntity("http://localhost:8301/rest/stock/get-string", String.class);
        System.out.println(call.getBody());
    }

}