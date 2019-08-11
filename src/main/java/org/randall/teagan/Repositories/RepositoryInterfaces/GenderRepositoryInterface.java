package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domains.Demography.Gender;

import java.util.HashMap;

public interface GenderRepositoryInterface extends IRepository<Gender, String> {
    void removeAll();
    HashMap<String, Gender> getAll();
}
