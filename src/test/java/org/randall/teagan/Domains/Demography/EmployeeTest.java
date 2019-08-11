package org.randall.teagan.Domains.Demography;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Factories.EmployeeFactory;

import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee emp1 = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Teagan", "Randall");
    Employee emp2 = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Fortune", "Dederen");

    @Test
    public void getName() {
        assertNotNull(emp1.getName());
        assertTrue(emp1.getName() instanceof String);
        assertNotEquals(emp1.getName(), emp2.getName());
        assertEquals(emp1.getName(), "Teagan");
        System.out.println("Employee 1's name: " + emp1.getName());
    }

    @Test
    public void getLastname() {
        assertNotNull(emp1.getLastname());
        assertTrue(emp1.getLastname() instanceof String);
        assertNotEquals(emp1.getLastname(), emp2.getLastname());
        assertEquals(emp1.getLastname(), "Randall");
        System.out.println("Employee 1's lastname: " + emp1.getLastname());
    }

    @Test
    public void getId() {
        assertNotNull(emp1.getId());
        assertTrue(emp1.getId() instanceof String);
        assertNotEquals(emp1.getId(), emp2.getId());
        System.out.println("Employee 1's UUID: " + emp1.getId());
    }

    @Test
    public void toString1() {
        assertNotNull(emp1.toString());
        assertTrue(emp1.toString() instanceof String);
        System.out.println(emp1.toString());
    }
}