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

        Halt policeHalt = new Halt();
        Halt arpicoHalt = new Halt();
        Halt roxyHalt = new Halt();
        Halt williamHalt = new Halt();
        Halt flyOverHalt = new Halt();

        policeHalt.setId(1);
        policeHalt.setName("Wellawatte Police Station");
        policeHalt.setNextHalt(new Halt());
        policeHalt.setPreviousHalt(arpicoHalt);

        arpicoHalt.setId(2);
        arpicoHalt.setName("wellawatte arpico");
//        arpicoHalt.setNextHaltName("wellawatte police");
        arpicoHalt.setNextHalt(policeHalt);
        arpicoHalt.setPreviousHalt(roxyHalt);
//        arpicoHalt.setPreviousHaltName("dehiwala roxy");

        roxyHalt.setId(3);
        roxyHalt.setName("Dehiwala roxy");
//        roxyHalt.setNextHaltName("Wellawatter arpico");
        roxyHalt.setNextHalt(arpicoHalt);
//        roxyHalt.setPreviousHaltName("dehiwala william");
        roxyHalt.setPreviousHalt(williamHalt);

        williamHalt.setId(4);
        williamHalt.setName("Dehiwala william");
//        williamHalt.setNextHaltName("dehiwala roxy");
        williamHalt.setNextHalt(roxyHalt);
//        williamHalt.setPreviousHaltName("dehiwala flyover");
        williamHalt.setPreviousHalt(flyOverHalt);

        flyOverHalt.setId(5);
        flyOverHalt.setName("Dehiwal fly over");
        flyOverHalt.setNextHalt(williamHalt);
        flyOverHalt.setPreviousHalt(new Halt());

        halts.add(policeHalt);
        halts.add(arpicoHalt);
        halts.add(roxyHalt);
        halts.add(williamHalt);
        halts.add(flyOverHalt);
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

}
