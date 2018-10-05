package org.sliit.service;

import org.sliit.model.Halt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneyService {

    public List<Halt> createHalts() {

        Halt arpicoHalt = new Halt();
        Halt roxyHalt = new Halt();
        Halt williamHalt = new Halt();


        arpicoHalt.setName("wellawatte arpico");
        arpicoHalt.setNextHaltName("wellawatte police");
        arpicoHalt.setPreviousHaltName("dehiwala roxy");

        roxyHalt.setName("Dehiwala roxy");
        roxyHalt.setNextHaltName("Wellawatter arpico");
        roxyHalt.setNextHalt(arpicoHalt);
        roxyHalt.setPreviousHaltName("dehiwala william");
        roxyHalt.setPreviousHalt(williamHalt);

        williamHalt.setName("Dehiwala william");
        williamHalt.setNextHaltName("dehiwala roxy");
        williamHalt.setPreviousHaltName("dehiwala flyover");

        List<Halt> halts = new ArrayList<>();
        halts.add(arpicoHalt);
        halts.add(williamHalt);

        return halts;
    }

    public String start() {
        return "start";
    }

}
