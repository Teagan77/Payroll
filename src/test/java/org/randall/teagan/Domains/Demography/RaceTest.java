package org.randall.teagan.Domains.Demography;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Factories.RaceFactory;

import java.util.UUID;

import static org.junit.Assert.*;

public class RaceTest {

    Race caucasian = new RaceFactory().getRace(UUID.randomUUID().toString(), "This is a caucasian." );
    Race indonesian = new RaceFactory().getRace(UUID.randomUUID().toString(), "This is an indonesian." );

    @Test
    public void getRaceID() {
        assertNotNull(caucasian);
        assertTrue(caucasian.getRaceID() instanceof String);
        assertFalse(caucasian.getRaceID().equals(indonesian.getRaceID()));
        System.out.println("Generated raceId (caucasian): " + caucasian.getRaceID() + "\n");
    }

    @Test
    public void getRaceDesc() {
        assertNotNull(indonesian);
        assertTrue(indonesian.getRaceDesc() instanceof String);
        assertEquals(indonesian.getRaceDesc(), "This is an indonesian.");
        System.out.println("Race description (indonesian): " + indonesian.getRaceDesc() + "\n");
    }

    @Test
    public void testToString() {
        assertNotNull(caucasian.toString());
        assertTrue(caucasian.toString() instanceof String);
        System.out.println("Race (caucasian) toString: " + caucasian.toString());
    }
}
