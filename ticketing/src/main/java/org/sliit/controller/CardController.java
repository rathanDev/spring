package org.sliit.controller;

import org.sliit.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        String s = cardService.create();
        System.out.println("s = " + s);
        return "card";
    }

}
