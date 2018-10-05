package org.sliit.service;

import org.sliit.model.Halt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneyService {

    private List<Halt> halts = new ArrayList<>();

    public JourneyService() {
        createHalts();
    }

    private void createHalts() {

        Halt arpicoHalt = new Halt();
        Halt roxyHalt = new Halt();
        Halt williamHalt = new Halt();


        arpicoHalt.setId(1);
        arpicoHalt.setName("wellawatte arpico");
        arpicoHalt.setNextHaltName("wellawatte police");
        arpicoHalt.setPreviousHaltName("dehiwala roxy");

        roxyHalt.setId(2);
        roxyHalt.setName("Dehiwala roxy");
        roxyHalt.setNextHaltName("Wellawatter arpico");
        roxyHalt.setNextHalt(arpicoHalt);
        roxyHalt.setPreviousHaltName("dehiwala william");
        roxyHalt.setPreviousHalt(williamHalt);

        williamHalt.setId(3);
        williamHalt.setName("Dehiwala william");
        williamHalt.setNextHaltName("dehiwala roxy");
        williamHalt.setPreviousHaltName("dehiwala flyover");

        halts.add(arpicoHalt);
        halts.add(roxyHalt);
        halts.add(williamHalt);
    }

    public List<Halt> getHalts() {
        return halts;
    }

    public Halt findById(int id) {
        Halt selected = halts.get(0);
        for(Halt halt : halts) {
            if(halt.getId() == id) {
                selected = halt;
                break;
            }
        }
        return selected;
    }

    public String start() {
        return "start";
    }

}
