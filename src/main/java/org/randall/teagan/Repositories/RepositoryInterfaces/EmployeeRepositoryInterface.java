package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domains.Demography.Employee;

import java.util.HashMap;

public interface EmployeeRepositoryInterface extends IRepository<Employee, String> {
    void removeAll();
    HashMap<String, Employee> getAll();
}
