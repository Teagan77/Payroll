package org.randall.teagan.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Factories.EmployeeFactory;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository;
    private Employee employee1 = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Teagan", "Randall");
    private Employee employee2 = EmployeeFactory.getEmployee(UUID.randomUUID().toString(), "Fortune", "Dederen");

    @Before
    public void setUp() throws Exception {
        this.employeeRepository = EmployeeRepository.getEmployeeRepository();
    }

    @Test
    public void removeAll() {
        this.employeeRepository.create(employee1);
        this.employeeRepository.create(employee2);
        HashMap<String, Employee> tempHashMap = this.employeeRepository.getAll();
        System.out.println("Values before removeAll: \n" + tempHashMap.values());
        this.employeeRepository.removeAll();
        System.out.println("Values after removeAll(): \n" + tempHashMap.values());
        assertEquals(0, tempHashMap.size());
    }

    @Test
    public void getAll() {
        this.employeeRepository.create(employee1);
        this.employeeRepository.create(employee2);
        HashMap<String, Employee> tempHashMap = this.employeeRepository.getAll();
        assertNotNull(tempHashMap);
        System.out.println("All values within temporary getAll() employee hashmap: \n" + tempHashMap.values() + "\n");
    }

    @Test
    public void create() {
        assertEquals(employee1.getId(), this.employeeRepository.create(employee1).getId());
        assertNotNull(this.employeeRepository.getAll());
        System.out.println("Created employee: " + employee1.toString() + "\n");
    }

    @Test
    public void update() {
        this.employeeRepository.create(employee1);
        Employee newMale = EmployeeFactory.getEmployee(employee1.getId(), "Teagan", "Oakley");
        System.out.println("Updated: " + this.employeeRepository.read(employee1.getId()).toString());
        this.employeeRepository.update(newMale);
        System.out.println("To: " + this.employeeRepository.read(newMale.getId()).toString() + "\n");
        assertEquals(employee1.getId(), newMale.getId());
        assertEquals("Oakley", this.employeeRepository.read(newMale.getId()).getLastname());
    }

    @Test
    public void delete() {
        this.employeeRepository.create(employee1);
        System.out.println("Created employee: " + employee1.toString());
        this.employeeRepository.create(employee2);
        System.out.println("Created employee: " + employee2.toString());
        this.employeeRepository.delete(employee2.getId());
        System.out.println("Deleted employee2, all employees currently present in array: " + this.employeeRepository.getAll());
        assertEquals(null, this.employeeRepository.read(employee2.getId()));
    }

    @Test
    public void read() {
        this.employeeRepository.create(employee1);
        this.employeeRepository.create(employee2);
        assertTrue(this.employeeRepository.read(employee1.getId()) instanceof Employee);
        assertEquals(employee1.hashCode(), this.employeeRepository.read(employee1.getId()).hashCode());
        System.out.println("Read this employee: \n" + this.employeeRepository.read(employee1.getId()).toString() + "\n");
    }

    @After
    public void tearDown() throws Exception {
        this.employeeRepository.removeAll();
    }
}
