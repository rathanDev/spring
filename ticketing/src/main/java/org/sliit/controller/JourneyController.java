package org.sliit.controller;

import org.sliit.model.Halt;
import org.sliit.model.Journey;
import org.sliit.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        journeyService.save(new Journey(fromHalt, toHalt));
        return "ok";
    }


}
