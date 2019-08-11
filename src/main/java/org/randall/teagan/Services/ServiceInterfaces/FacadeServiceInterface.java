package org.randall.teagan.Services.ServiceInterfaces;

import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Domains.Demography.Race;

public interface FacadeServiceInterface {

    Employee saveEmployee(String empID, String empName, String empSurname, Gender gender, Race race);

    Gender getEmployeeGender(String id);

    Race getEmployeeRace(String id);
}
