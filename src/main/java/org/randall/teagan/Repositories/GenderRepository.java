package org.randall.teagan.Repositories;

import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Repositories.RepositoryInterfaces.GenderRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("GenderRepository")
public class GenderRepository implements GenderRepositoryInterface {

    private HashMap<String, Gender> genderDB;
    private static GenderRepository genderRepository = null;

    private GenderRepository() {
        this.genderDB = new HashMap<>();
    }

    public static GenderRepository getGenderRepository() {
        if (genderRepository == null) {
            genderRepository = new GenderRepository();
        }
        return genderRepository;
    }

    @Override
    public void removeAll() {
    genderDB.clear();
    }

    @Override
    public HashMap<String, Gender> getAll() {
        return genderDB;
    }

    @Override
    public Gender create(Gender gender) {
        this.genderDB.put(gender.getGenderId(), gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        Gender genderToBeDeleted = read(gender.getGenderId());
            if(genderToBeDeleted != null){
                this.genderDB.remove(genderToBeDeleted.getGenderId());
                return create(gender);
            }
        return null;
    }

    @Override
    public void delete(String genderID) {
        genderDB.remove(genderID);
    }

    @Override
    public Gender read(String genderID) {
        for(Gender gender : genderDB.values()){
            if(gender.getGenderId().equals(genderID)){
                return gender;
            }
        }
        return null;
    }
}
