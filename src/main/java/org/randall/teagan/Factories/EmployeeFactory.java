package org.randall.teagan.Factories;

import org.randall.teagan.Domains.Demography.Employee;

public class EmployeeFactory {

    public static Employee getEmployee(String id, String name, String lastname) {
        return new Employee.empBuilder()
                .empId(id)
                .empName(name)
                .empLastname(lastname)
                .build();

    }
}
