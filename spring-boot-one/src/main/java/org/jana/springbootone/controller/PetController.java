package org.jana.springbootone.controller;

import io.swagger.annotations.ApiParam;
import org.jana.springbootone.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/pet")
public class PetController {

    @RequestMapping("/pet")
    public String index() {
        return "Greeting from pet controller!";
    }

//    @RequestMapping("/")
//    public String index() {
//        System.out.println("Greeting from pet controller!");
//        return "Greeting from pet controller!";
//    }

/*    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,10]", required = true) @PathVariable("id") Integer petId) throws Exception {
        System.out.println("Get pet by id, " + petId);
        Pet pet = new Pet();
        pet.setId(1);
        return ResponseEntity.ok().body(pet);
    }*/

}
