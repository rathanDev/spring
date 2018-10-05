package org.sliit.controller;

import org.sliit.model.Halt;
import org.sliit.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/journey")
public class JourneyController {

    @Autowired
    JourneyService journeyService;

    @GetMapping("/start")
    public String greetingSubmit(Model model) {
        List<Halt> halts = journeyService.createHalts();
        System.out.println("halts = " + halts);
        model.addAttribute("halts", halts);
        return "journey";
    }

}
