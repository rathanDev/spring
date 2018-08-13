package org.jana.stockservice.model;

public class StockQuote {

    private String name;

    public StockQuote() {
    }

    public StockQuote(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
