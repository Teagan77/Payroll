package org.randall.teagan.Services;

import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Repositories.GenderRepository;
import org.randall.teagan.Repositories.RepositoryInterfaces.GenderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("GenderService")
public class GenderService implements GenderRepositoryInterface {

    @Autowired
    @Qualifier("GenderService_GenderRepo")
    private GenderRepository genderRepository;

    @Override
    public void removeAll() {
        genderRepository.removeAll();
    }

    @Override
    public HashMap<String, Gender> getAll() {
        return genderRepository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return genderRepository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return genderRepository.update(gender);
    }

    @Override
    public void delete(String genderID) {
        genderRepository.delete(genderID);
    }

    @Override
    public Gender read(String genderID) {
        return genderRepository.read(genderID);
    }
}
