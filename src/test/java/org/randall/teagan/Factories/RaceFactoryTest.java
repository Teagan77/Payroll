package org.randall.teagan.Factories;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Race;

import java.util.UUID;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void getRace() {
        Race caucasian = new RaceFactory().getRace(UUID.randomUUID().toString(), "This is a caucasian." );
        assertNotNull(caucasian);
        System.out.println(caucasian.toString());
    }
}
