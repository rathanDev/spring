package org.jana.service;

import org.jana.model.Halt;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HaltService {

    private int id = 1;
    private Map<Integer, Halt> haltMap = new HashMap<>();

    HaltService() {
      createHalts();
    }

    private void createHalts() {

        Halt policeHalt = new Halt();
        Halt arpicoHalt = new Halt();
        Halt roxyHalt = new Halt();
        Halt williamHalt = new Halt();
        Halt flyOverHalt = new Halt();

        policeHalt.setId(id++);
        policeHalt.setName("Wellawatte Police Station");
        policeHalt.setNextHalt(new Halt());
        policeHalt.setPreviousHalt(arpicoHalt);

        arpicoHalt.setId(id++);
        arpicoHalt.setName("wellawatte arpico");
        arpicoHalt.setNextHalt(policeHalt);
        arpicoHalt.setPreviousHalt(roxyHalt);

        roxyHalt.setId(id++);
        roxyHalt.setName("Dehiwala roxy");
        roxyHalt.setNextHalt(arpicoHalt);
        roxyHalt.setPreviousHalt(williamHalt);

        williamHalt.setId(id++);
        williamHalt.setName("Dehiwala william");
        williamHalt.setNextHalt(roxyHalt);
        williamHalt.setPreviousHalt(flyOverHalt);

        flyOverHalt.setId(id++);
        flyOverHalt.setName("Dehiwal fly over");
        flyOverHalt.setNextHalt(williamHalt);
        flyOverHalt.setPreviousHalt(new Halt());

        haltMap.put(policeHalt.getId(), policeHalt);
        haltMap.put(arpicoHalt.getId(), arpicoHalt);
        haltMap.put(roxyHalt.getId(), roxyHalt);
        haltMap.put(williamHalt.getId(), williamHalt);
        haltMap.put(flyOverHalt.getId(), flyOverHalt);
    }

    public List<Halt> getAll() {
        Collection<Halt> values = haltMap.values();
        List<Halt> halts = new ArrayList<>(values);
        return halts;
    }

    public Halt findById(int id) {
        return haltMap.get(id);
    }

    public List<Halt> saveOrUpdate(Halt halt) {
        System.out.println("halt = " + halt);
        if(halt.getId() == 0) {
            halt.setId(id++);
        }
        haltMap.put(halt.getId(), halt);
        return getAll();
    }


}
