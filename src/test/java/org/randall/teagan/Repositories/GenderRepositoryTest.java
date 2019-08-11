package org.randall.teagan.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Factories.GenderFactory;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.*;

public class GenderRepositoryTest {

    private GenderRepository genderRepository;
    private Gender male = GenderFactory.getGender(UUID.randomUUID().toString(), "This is a Male.");
    private Gender female = GenderFactory.getGender(UUID.randomUUID().toString(), "This is a Female.");

    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepository.getGenderRepository();
    }

    @Test
    public void removeAll() {
        this.genderRepository.create(male);
        this.genderRepository.create(female);
        HashMap<String, Gender> tempHashMap = this.genderRepository.getAll();
        System.out.println("Values before removeAll: \n" + tempHashMap.values());
        this.genderRepository.removeAll();
        System.out.println("Values after removeAll(): \n" + tempHashMap.values());
        assertEquals(0, tempHashMap.size());
    }

    @Test
    public void getAll() {
        this.genderRepository.create(male);
        this.genderRepository.create(female);
        HashMap<String, Gender> tempHashMap = this.genderRepository.getAll();
        assertNotNull(tempHashMap);
        System.out.println("All values within temporary getAll() gender hashmap: \n" + tempHashMap.values() + "\n");
    }

    @Test
    public void create() {
        assertEquals(male.getGenderId(), this.genderRepository.create(male).getGenderId());
        assertNotNull(this.genderRepository.getAll());
        System.out.println("Created gender: " + male.toString() + "\n");
    }

    @Test
    public void update() {
        this.genderRepository.create(male);
        Gender newMale = GenderFactory.getGender(male.getGenderId(), "This is an updated male.");
        System.out.println("Updated: " + this.genderRepository.read(male.getGenderId()).toString());
        this.genderRepository.update(newMale);
        System.out.println("To: " + this.genderRepository.read(newMale.getGenderId()).toString() + "\n");
        assertEquals(male.getGenderId(), newMale.getGenderId());
        assertEquals("This is an updated male.", this.genderRepository.read(newMale.getGenderId()).getGenderDesc());
    }

    @Test
    public void delete() {
        this.genderRepository.create(male);
        System.out.println("Created gender: " + male.toString());
        this.genderRepository.create(female);
        System.out.println("Created gender: " + female.toString());
        this.genderRepository.delete(female.getGenderId());
        System.out.println("Deleted female, all genders currently present in array: " + this.genderRepository.getAll());
        assertEquals(null, this.genderRepository.read(female.getGenderId()));
    }

    @Test
    public void read() {
        this.genderRepository.create(male);
        this.genderRepository.create(female);
        assertTrue(this.genderRepository.read(male.getGenderId()) instanceof Gender);
        assertEquals(male.hashCode(), this.genderRepository.read(male.getGenderId()).hashCode());
        System.out.println("Read this gender: \n" + this.genderRepository.read(male.getGenderId()).toString() + "\n");
    }

    @After
    public void tearDown() throws Exception {
        this.genderRepository.removeAll();
    }
}
