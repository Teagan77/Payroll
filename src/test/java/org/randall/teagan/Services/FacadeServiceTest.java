package org.randall.teagan.Services;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Factories.GenderFactory;
import org.randall.teagan.Factories.RaceFactory;

import java.util.UUID;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacadeServiceTest {

    private FacadeService facadeService;
    private Race caucasian;
    private Gender male;

    @Before
    public void setUp() throws Exception {
        facadeService = new FacadeService();
        caucasian = RaceFactory.getRace(UUID.randomUUID().toString(), "This is a caucasian.");
        male = GenderFactory.getGender(UUID.randomUUID().toString(), "This is a male.");
    }

    @After
    public void tearDown() throws Exception {
        this.facadeService.removeAll();
    }

    @Test
    public void a_saveEmployee() {
        Employee employee1 = facadeService.saveEmployee(UUID.randomUUID().toString(), "Teagan", "Randall", male, caucasian);
        System.out.println("Created employee: " + employee1 + "\n");
        assertNotNull(employee1);
        assertNotNull(facadeService.empRepository.getAll());
    }

    @Test
    public void b_getEmployeeGender() {
        Employee employee1 = facadeService.saveEmployee(UUID.randomUUID().toString(), "Teagan", "Randall", male, caucasian);
        System.out.println("This employee's gender is: " + facadeService.getEmployeeGender(male.getGenderId()) + "\n");
        assertNotNull(facadeService.genderRepository.getAll());
    }

    @Test
    public void c_getEmployeeRace() {
        Employee employee1 = facadeService.saveEmployee(UUID.randomUUID().toString(), "Teagan", "Randall", male, caucasian);
        System.out.println("This employee's race is: " + facadeService.getEmployeeRace(caucasian.getRaceID()) + "\n");
        assertNotNull(facadeService.raceRepository.getAll());
    }

    @Test
    public void d_getGenderHash() {
        Employee employee1 = facadeService.saveEmployee(UUID.randomUUID().toString(), "Teagan", "Randall", male, caucasian);
        System.out.println("This employee's genderHash is: " + facadeService.getGenderHash() + "\n");
    }

    @Test
    public void e_getRaceHash() {
        Employee employee1 = facadeService.saveEmployee(UUID.randomUUID().toString(), "Teagan", "Randall", male, caucasian);
        System.out.println("This employee's raceHash is: " + facadeService.getRaceHash() + "\n");
    }
}