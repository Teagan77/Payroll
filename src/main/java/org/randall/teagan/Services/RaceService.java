package org.randall.teagan.Services;

import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Repositories.RaceRepository;
import org.randall.teagan.Services.ServiceInterfaces.RaceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;

public class RaceService implements RaceServiceInterface {

    @Autowired
    @Qualifier("RaceService_RaceRepo")
    private RaceRepository raceRepository;

    @Override
    public Race create(Race race) {
        return raceRepository.create(race);
    }

    @Override
    public Race update(Race race) {
        return raceRepository.update(race);
    }

    @Override
    public void delete(String raceID) {
        raceRepository.delete(raceID);
    }

    @Override
    public Race read(String raceID) {
        return raceRepository.read(raceID);
    }

    @Override
    public void removeAll() {
        raceRepository.removeAll();
    }

    @Override
    public HashMap<String, Race> getAll() {
        return raceRepository.getAll();
    }
}
