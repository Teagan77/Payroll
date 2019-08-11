package org.randall.teagan.Factories;

import org.junit.Test;
import org.randall.teagan.Domains.Demography.Employee;

import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee() {
        Employee emp1 = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Teagan", "Randall");
        assertNotNull(emp1);
        System.out.println(emp1.toString());
    }
}