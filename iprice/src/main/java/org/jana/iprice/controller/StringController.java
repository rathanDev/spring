package org.jana.iprice.controller;

import org.jana.iprice.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringController {

    @Autowired
    private StringService stringService;

    @RequestMapping("/upper/{input}")
    public ResponseEntity<String> convertToUpper(@PathVariable("input") String input) {
        return ResponseEntity
                .ok(stringService.convertToUpperCase(input));
    }

    @RequestMapping("/alternate/{input}")
    public ResponseEntity<String> convertToAlternateCases(@PathVariable("input") String input) {
        return ResponseEntity
                .ok(stringService.convertToAlternateCases(input));
    }

    @RequestMapping("/csv/{input}")
    public ResponseEntity<String> convertToCSV(@PathVariable("input") String input) {
        return ResponseEntity
                .ok(stringService.convertToCSV(input));
    }

}
