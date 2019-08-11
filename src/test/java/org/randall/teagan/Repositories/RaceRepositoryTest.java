package org.randall.teagan.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Factories.RaceFactory;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.*;

public class RaceRepositoryTest {

    private RaceRepository raceRepository;
    private Race caucasian = RaceFactory.getRace(UUID.randomUUID().toString(), "This is a caucasian.");
    private Race indonesian = RaceFactory.getRace(UUID.randomUUID().toString(), "This is an indonesian.");

    @Before
    public void setUp() throws Exception {
        this.raceRepository = RaceRepository.getRaceRepository();
    }

    @Test
    public void removeAll() {
        this.raceRepository.create(caucasian);
        this.raceRepository.create(indonesian);
        HashMap<String, Race> tempHashMap = this.raceRepository.getAll();
        System.out.println("Values before removeAll: \n" + tempHashMap.values());
        this.raceRepository.removeAll();
        System.out.println("Values after removeAll(): \n" + tempHashMap.values());
        assertEquals(0, tempHashMap.size());
    }

    @Test
    public void getAll() {
        this.raceRepository.create(caucasian);
        this.raceRepository.create(indonesian);
        HashMap<String, Race> tempHashMap = this.raceRepository.getAll();
        assertNotNull(tempHashMap);
        System.out.println("All values within temporary getAll() race hashmap: \n" + tempHashMap.values() + "\n");
    }

    @Test
    public void create() {
        assertEquals(caucasian.getRaceID(), this.raceRepository.create(caucasian).getRaceID());
        assertNotNull(this.raceRepository.getAll());
        System.out.println("Created race: " + caucasian.toString() + "\n");
    }

    @Test
    public void update() {
        this.raceRepository.create(caucasian);
        Race caucasianAmerican = RaceFactory.getRace(caucasian.getRaceID(), "This is a caucasian-american.");
        System.out.println("Updated: " + this.raceRepository.read(caucasian.getRaceID()).toString());
        this.raceRepository.update(caucasianAmerican);
        System.out.println("To: " + this.raceRepository.read(caucasianAmerican.getRaceID()).toString() + "\n");
        assertEquals(caucasian.getRaceID(), caucasianAmerican.getRaceID());
        assertEquals("This is a caucasian-american.", this.raceRepository.read(caucasianAmerican.getRaceID()).getRaceDesc());
    }

    @Test
    public void delete() {
        this.raceRepository.create(caucasian);
        System.out.println("Created race: " + caucasian.toString());
        this.raceRepository.create(indonesian);
        System.out.println("Created race: " + indonesian.toString());
        this.raceRepository.delete(indonesian.getRaceID());
        System.out.println("Deleted indonesian, all races currently present in array: " + this.raceRepository.getAll());
        assertEquals(null, this.raceRepository.read(indonesian.getRaceID()));
    }

    @Test
    public void read() {
        this.raceRepository.create(caucasian);
        this.raceRepository.create(indonesian);
        assertTrue(this.raceRepository.read(caucasian.getRaceID()) instanceof Race);
        assertEquals(caucasian.hashCode(), this.raceRepository.read(caucasian.getRaceID()).hashCode());
        System.out.println("Read this race: \n" + this.raceRepository.read(caucasian.getRaceID()).toString() + "\n");
    }

    @After
    public void tearDown() throws Exception {
        this.raceRepository.removeAll();
    }
}
