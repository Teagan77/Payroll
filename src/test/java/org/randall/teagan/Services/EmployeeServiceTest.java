package org.randall.teagan.Services;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Factories.EmployeeFactory;
import org.randall.teagan.Repositories.EmployeeRepository;

import java.util.UUID;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {

    private EmployeeRepository employeeRepository;
    private Employee employee;

    @Before
    public void setUp(){
        this.employeeRepository = EmployeeRepository.getEmployeeRepository();
        this.employee = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Teagan", "Randall");
    }

    @Test
    public void a_create() {
        Employee employee1 = this.employeeRepository.create(this.employee);
        System.out.println("Created employee: " + employee1 + "\n");
        assertNotNull(employee1);
        assertSame(employee1, this.employee);
    }

    @Test
    public void c_update() {
//        String newEmpName = "Jeffrey";
//        Employee updated;
//        System.out.println("Updated employee : " + updated);
//        this.employeeRepository.update(updated);
//        assertSame(newCourseName, updated.getCourseName());
    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void getAll() {
    }

    @After
    public void tearDown(){

    }
}
