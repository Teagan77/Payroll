package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domains.Demography.Race;

import java.util.HashMap;

public interface RaceRepositoryInterface extends IRepository<Race, String> {

    void removeAll();
    HashMap<String, Race> getAll();
}
