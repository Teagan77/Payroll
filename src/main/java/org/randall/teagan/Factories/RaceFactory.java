package org.randall.teagan.Factories;

import org.randall.teagan.Domains.Demography.Race;

public class RaceFactory {

    public static Race getRace(String raceID, String raceDesc) {
        return new Race.RaceBuilder()
                .raceID(raceID)
                .raceDesc(raceDesc)
                .build();
    }
}
