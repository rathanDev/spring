package org.sliit.service;

import org.sliit.model.Halt;
import org.sliit.model.Journey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneyService {

    private List<Journey> journeys = new ArrayList<>();

    public JourneyService() {
    }

    public void save(Journey journey) {
        System.out.println("Save " + journey);
        journeys.add(journey);
        System.out.println("Journeys " + journeys);
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

}
