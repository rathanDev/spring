package org.sliit.controller;

import org.sliit.model.Halt;
import org.sliit.service.HaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/halt")
public class HaltController {

    @Autowired
    HaltService haltService;

    @GetMapping("/manage")
    public String manage() {
        return "haltManagement";
    }

    @GetMapping("/find/{haltId}")
    @ResponseBody
    public Halt find(@PathVariable("haltId") int haltid) {
        System.out.println("selected haltid = " + haltid);
        Halt selectedHalt = haltService.findById(haltid);
        System.out.println("selectedHalt = " + selectedHalt);

        Halt halt = new Halt();
        halt.setNextHaltName(selectedHalt.getNextHalt().getName());
        halt.setPreviousHaltName(selectedHalt.getPreviousHalt().getName());
        System.out.println("halt = " + halt);

        return halt;
    }

    @PostMapping("/save/haltName/{haltName}/nextHaltId/{nextHaltId}/previousHaltId/{previousHaltId}")
    @ResponseBody
    public String save(@PathVariable("haltName") String haltName,
                       @PathVariable("nextHaltId") int nextHaltId,
                       @PathVariable("previousHaltId") int previousHaltId) {
        Halt nextHalt = haltService.findById(nextHaltId);
        Halt previousHalt = haltService.findById(previousHaltId);
        List<Halt> halts = haltService.saveOrUpdate(new Halt(haltName, nextHalt, previousHalt));
        System.out.println("halts = " + halts);
        return "ok";
    }

    @PostMapping("/update/haltId/{haltId}/haltName/{haltName}/nextHaltId/{nextHaltId}/previousHaltId/{previousHaltId}")
    @ResponseBody
    public String update(@PathVariable("haltId") int haltId,
                         @PathVariable("haltName") String haltName,
                         @PathVariable("nextHaltId") int nextHaltId,
                         @PathVariable("previousHaltId") int previousHaltId) {
        Halt halt = haltService.findById(haltId);
        Halt nextHalt = haltService.findById(nextHaltId);
        Halt previousHalt = haltService.findById(previousHaltId);
        halt.setName(haltName);
        halt.setNextHalt(nextHalt);
        halt.setPreviousHalt(previousHalt);
        List<Halt> halts = haltService.saveOrUpdate(halt);
        System.out.println("halts = " + halts);
        return "ok";
    }

}
