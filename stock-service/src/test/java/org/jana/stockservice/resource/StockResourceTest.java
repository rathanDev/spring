package org.jana.stockservice.resource;

import org.jana.stockservice.model.StockQuote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockResourceTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGet() {
        System.out.println("Get sample string");
        ResponseEntity<String> call= restTemplate.getForEntity("http://localhost:8301/rest/stock/sample-string", String.class);
        System.out.println(call.getBody());
    }

    @Test
    public void testGetSampleStock() {
        System.out.println("Get sample stock");
        ResponseEntity<StockQuote> call= restTemplate.getForEntity("http://localhost:8301/rest/stock/sample", StockQuote.class);
        System.out.println(call.getBody());
    }

    @Test
    public void testGetDb() {
        System.out.println("Get db");
        ResponseEntity<ArrayList> call= restTemplate.getForEntity("http://localhost:8300/rest/db/jana", ArrayList.class);
        List<String> quotes = call.getBody();
        quotes.stream().forEach(q -> System.out.println(q));
    }

}