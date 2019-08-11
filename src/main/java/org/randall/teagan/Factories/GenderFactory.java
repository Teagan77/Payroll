package org.randall.teagan.Factories;

import org.randall.teagan.Domains.Demography.Gender;

public class GenderFactory {

    public static Gender getGender(String id, String description) {
        return new Gender.GenderBuilder()
                .genderId(id)
                .genderDesc(description)
                .build();
    }
}
