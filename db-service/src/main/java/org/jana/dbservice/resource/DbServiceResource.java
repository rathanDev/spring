package org.jana.dbservice.resource;

import org.jana.dbservice.model.Quote;
import org.jana.dbservice.model.Quotes;
import org.jana.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {
        System.out.println("GetQuotes");
        return getQuotesByUsername(username);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        System.out.println("Add");
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUsername(), quote))
                .forEach(quote -> quotesRepository.save(quote));
        return getQuotesByUsername(quotes.getUsername());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {
        System.out.println("Delete " + username);
        List<Quote> quotes = quotesRepository.findByUsername(username);
        quotesRepository.deleteAll(quotes);
        return getQuotesByUsername(username);
    }

    private List<String> getQuotesByUsername(String username) {
        System.out.println("getQuotesByUsername, username = " + username);
        return quotesRepository.findByUsername(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

}
