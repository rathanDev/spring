package org.sliit.controller;

import org.sliit.model.Halt;
import org.sliit.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/journey")
public class JourneyController {

    @Autowired
    JourneyService journeyService;

    @GetMapping("/start")
    public String start(Model model) {
        List<Halt> halts = journeyService.getHalts();
        System.out.println("halts = " + halts);
        model.addAttribute("halts", halts);
        return "journey";
    }

    @GetMapping("/find/{haltId}")
    @ResponseBody
    public Halt find(@PathVariable("haltId") int haltid) {
        System.out.println("selected haltid = " + haltid);
        Halt halt = journeyService.findById(haltid);
        System.out.println("selected halt = " + halt);
        return halt;
    }


}
