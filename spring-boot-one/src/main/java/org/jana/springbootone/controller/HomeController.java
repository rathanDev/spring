package org.jana.springbootone.controller;

import org.jana.springbootone.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "Greeting from this boot!!!";
    }

    @RequestMapping("/sample-get")
    public String sampleGet() {
        return "sample get results -";
    }

    @RequestMapping("/pets")
    public String getPets() {
        System.out.println("getPets()");
        return "pets";
    }

    @RequestMapping(value = "/vpets", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> getPetsValue() {
        System.out.println("vpets");
        Pet pet = new Pet();
        pet.setId(1);
        return ResponseEntity.ok().body(pet);
    }

}
