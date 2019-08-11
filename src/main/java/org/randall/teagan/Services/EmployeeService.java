package org.randall.teagan.Services;

import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Repositories.EmployeeRepository;
import org.randall.teagan.Services.ServiceInterfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("EmployeeService")
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    @Qualifier("EmployeeService_EmployeeRepo")
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public void delete(String employeeID) {
        employeeRepository.delete(employeeID);
    }

    @Override
    public Employee read(String employeeID) {
        return employeeRepository.read(employeeID);
    }

    @Override
    public void removeAll() {
        employeeRepository.removeAll();
    }

    @Override
    public HashMap<String, Employee> getAll() {
        return employeeRepository.getAll();
    }
}
