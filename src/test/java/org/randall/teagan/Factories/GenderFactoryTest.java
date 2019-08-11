package org.randall.teagan.Factories;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Gender;

import java.util.UUID;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Test
    public void getGender() {
        Gender female = new GenderFactory().getGender(UUID.randomUUID().toString(), "This is a Female.");
        assertNotNull(female);
        System.out.println(female.toString());
    }
}
