package org.jana.springbootone.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jana.springbootone.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

    @RequestMapping("")
    public String index() {
        return "Greeting from pet controller";
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = "application/json")
    public String getId() {
        System.out.println("get id");
        return "id";
    }
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> getJson() {
        System.out.println("get pet ");
        Pet pet = new Pet();
        pet.setId(1);
        return ResponseEntity.ok().body(pet);
    }

    @ApiOperation(notes = "Returns a pet when 0 < ID <= 10.  ID > 10 or non-integers will simulate API errors",
            value = "Find pet by ID",
            nickname = "getPetById",
            tags = {"Pets"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Nice!", response = Pet.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Pet.class),
            @ApiResponse(code = 404, message = "Pet not found", response = Pet.class)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> getPet(
            @ApiParam(value = "ID of pet that needs to be fetched",
                    allowableValues = "range[1,10]",
                    required = true)
            @PathVariable("id") Integer petId) {
        System.out.println("getPet " + petId);
        Pet pet = new Pet();
        pet.setId(petId);
        return ResponseEntity.ok().body(pet);
    }

}
