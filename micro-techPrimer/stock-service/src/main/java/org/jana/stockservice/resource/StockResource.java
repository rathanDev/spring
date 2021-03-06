package org.jana.stockservice.resource;

import org.jana.stockservice.model.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @Autowired
    RestTemplate restTemplate;


//    List<String> quotes = restTemplate.getForObject("http://localhost:8300/rest/db" + username, List.class);
//     @Override
//                    public Type getType() {
//                        return super.getType();
//                    }


    @GetMapping("/sample-string")
    public String getString() {
        System.out.println("Get sample string");
        return "test-string here";
    }

    @GetMapping("/sample")
    public StockQuote getStock() {
        System.out.println("Get sample stock");
        return new StockQuote("test");
    }

    @GetMapping("get/{username}")
    public List<Quote> getStock(@PathVariable("username") final String username) {
        System.out.println("Get stock, username:" + username);
        ResponseEntity<ArrayList> call= restTemplate.getForEntity("http://db-service/rest/db/" + username, ArrayList.class);
        List<String> quotes = call.getBody();
        return quotes.stream()
                .map(quote -> {
                    BigDecimal price = getStockPrice(quote);
                    return new Quote(quote, price);
                })
                .collect(Collectors.toList());
    }

    private BigDecimal getStockPrice(String quote) {
        System.out.println("Get stock price, quote:" + quote);
        try {
            return YahooFinance.get(quote).getQuote().getPrice();
        } catch (IOException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    private class Quote {
        private final String quote;
        private final BigDecimal price;

        public Quote(String quote, BigDecimal price) {
            this.quote = quote;
            this.price = price;
        }

        public String getQuote() {
            return quote;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

}
