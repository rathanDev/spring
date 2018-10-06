package org.sliit.controller;

import org.sliit.model.Halt;
import org.sliit.model.Journey;
import org.sliit.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
        Halt selectedHalt = journeyService.findById(haltid);
        System.out.println("selectedHalt = " + selectedHalt);

        Halt halt = new Halt();
        halt.setNextHaltName(selectedHalt.getNextHalt().getName());
        halt.setPreviousHaltName(selectedHalt.getPreviousHalt().getName());
        System.out.println("halt = " + halt);

        return halt;
    }

    @PostMapping("/save/fromHalt/{fromHaltId}/toHalt/{toHaltId}")
    @ResponseBody
    public String save(@PathVariable("fromHaltId") int fromHaltId,
                       @PathVariable("toHaltId") int toHaltId) {
        Halt fromHalt = journeyService.findById(fromHaltId);
        Halt toHalt = journeyService.findById(toHaltId);
        journeyService.save(new Journey(new Date(), fromHalt, toHalt));
        return "ok";
    }

    @GetMapping("/history")
    public String getHistory(Model model) {
        System.out.println("Get history");

        List<Journey> journeys = new ArrayList<>();
        for(Journey journey: journeyService.getJourneys()) {
            journeys.add(new Journey(journey.getDate(), journey.getFromHalt().getName(), journey.getToHalt().getName()));
        }

//        journeys.add(new Journey(new Date(), "halt1", "halt2"));
//        journeys.add(new Journey(new Date(), "halt2", "halt3"));
//        journeys.add(new Journey(new Date(), "halt3", "halt4"));

        model.addAttribute("journeys", journeys);
        return "history";
    }

}
