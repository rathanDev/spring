package org.sliit.service;

import org.sliit.model.Halt;
import org.sliit.model.Journey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneyService {

    private List<Halt> halts = new ArrayList<>();
    private List<Journey> journeys = new ArrayList<>();

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
        arpicoHalt.setNextHalt(policeHalt);
        arpicoHalt.setPreviousHalt(roxyHalt);

        roxyHalt.setId(3);
        roxyHalt.setName("Dehiwala roxy");
        roxyHalt.setNextHalt(arpicoHalt);
        roxyHalt.setPreviousHalt(williamHalt);

        williamHalt.setId(4);
        williamHalt.setName("Dehiwala william");
        williamHalt.setNextHalt(roxyHalt);
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

    public void save(Journey journey) {
        System.out.println("Save " + journey);
        journeys.add(journey);
        System.out.println("Journeys " + journeys);
    }

}
