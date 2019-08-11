package org.randall.teagan.Repositories;

import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Repositories.RepositoryInterfaces.RaceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("RaceRepository")
public class RaceRepository implements RaceRepositoryInterface {

    private HashMap<String, Race>  raceDB;
    private static RaceRepository raceRepository = null;

    private RaceRepository() {
        this.raceDB = new HashMap<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null) {
            raceRepository = new RaceRepository();
        }
        return raceRepository;
    }

    @Override
    public void removeAll() {
        raceDB.clear();
    }

    @Override
    public HashMap<String, Race> getAll() {
        return raceDB;
    }

    @Override
    public Race create(Race race) {
        this.raceDB.put(race.getRaceID(), race);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race raceToBeDeleted = read(race.getRaceID());
        if(raceToBeDeleted != null){
            this.raceDB.remove(raceToBeDeleted.getRaceID());
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String raceID) {
        raceDB.remove(raceID);
    }

    @Override
    public Race read(String raceID) {
        for(Race race : raceDB.values()){
            if(race.getRaceID().equals(raceID)){
                return race;
            }
        }
        return null;
    }
}
