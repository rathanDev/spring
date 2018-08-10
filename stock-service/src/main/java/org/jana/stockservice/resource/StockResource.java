package org.jana.stockservice.resource;

import org.jana.stockservice.model.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{username}")
    public List<StockQuote> getStock(@PathVariable("username") final String username) {
        System.out.println("Get stock");
        List<String> quotes = restTemplate.getForObject("http://localhost:8300/rest/db" + username, List.class);

        return null;
    }
}
