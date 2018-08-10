package org.jana.dbservice.resource;

import org.jana.dbservice.model.Quote;
import org.jana.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {
        return quotesRepository.findByUsername(username)
                .stream()
                .map(quote -> quote.getQuote())
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quote quote) {
        return null;
    }

}
