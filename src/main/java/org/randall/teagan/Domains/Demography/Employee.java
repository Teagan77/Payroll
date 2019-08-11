package org.randall.teagan.Domains.Demography;

public class Employee {

    private String name, lastname, id;

    public Employee() {
    }

    private Employee(empBuilder empBuilder) {
        this.name = empBuilder.empName;
        this.lastname = empBuilder.empLastname;
        this.id = empBuilder.empId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static class empBuilder{

        private String empName, empLastname, empId;

        public empBuilder empId(String id) {
            this.empId = id;
            return this;
        }

        public empBuilder empName(String name) {
            this.empName = name;
            return this;
        }

        public empBuilder empLastname(String lastname) {
            this.empLastname = lastname;
            return this;
        }

        public Employee.empBuilder copy(Employee emp) {
            this.empId = emp.id;
            this.empName = emp.name;
            this.empLastname = emp.lastname;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
