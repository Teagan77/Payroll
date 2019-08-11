package org.randall.teagan.Domains.Demography;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Factories.GenderFactory;

import java.util.UUID;

import static org.junit.Assert.*;

public class GenderTest {

    Gender male = new GenderFactory().getGender(UUID.randomUUID().toString(), "This is a Male.");
    Gender female = new GenderFactory().getGender(UUID.randomUUID().toString(), "This is a Female.");

    @Test
    public void getGenderId() {
        assertNotNull(male.getGenderId());
        assertTrue(male.getGenderId() instanceof String);
        assertFalse(male.getGenderId().equals(female.getGenderId()));
        System.out.println("Generated GenderID (male): " + male.getGenderId() + "\n");
    }

    @Test
    public void getGenderDesc() {
        assertNotNull(male.getGenderDesc());
        assertTrue(male.getGenderDesc() instanceof String);
        assertEquals(male.getGenderDesc(), "This is a Male.");
        System.out.println("Gender description: " + male.getGenderDesc() + "\n");
    }

    @Test
    public void toString1() {
        assertNotNull(male.toString());
        assertTrue(male.toString() instanceof String);
        System.out.println("Gender toString: " + male.toString());
    }
}
