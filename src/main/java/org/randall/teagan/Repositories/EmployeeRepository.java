package org.randall.teagan.Repositories;

import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("EmployeeRepository")
public class EmployeeRepository implements EmployeeRepositoryInterface {

    private HashMap<String, Employee> employeeDB;
    private static EmployeeRepository employeeRepository = null;

    private EmployeeRepository() {
        this.employeeDB = new HashMap<>();
    }

    public static EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            employeeRepository = new EmployeeRepository();
        }
        return employeeRepository;
    }

    @Override
    public void removeAll() {
        employeeDB.clear();
    }

    @Override
    public HashMap<String, Employee> getAll() {
        return employeeDB;
    }

    @Override
    public Employee create(Employee employee) {
        this.employeeDB.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee empToBeDeleted = read(employee.getId());
        if(empToBeDeleted != null){
            this.employeeDB.remove(empToBeDeleted.getId());
            return create(employee);
        }
        return null;
    }

    @Override
    public void delete(String employeeID) {
        employeeDB.remove(employeeID);
    }

    @Override
    public Employee read(String employeeID) {
        for(Employee employee : employeeDB.values()){
            if(employee.getId().equals(employeeID)){
                return employee;
            }
        }
        return null;
    }
}
