package org.randall.teagan.Services;

import org.randall.teagan.Domains.Demography.Gender;
import org.randall.teagan.Domains.Demography.Race;
import org.randall.teagan.Domains.Demography.Employee;
import org.randall.teagan.Factories.EmployeeFactory;
import org.randall.teagan.Factories.GenderFactory;
import org.randall.teagan.Factories.RaceFactory;
import org.randall.teagan.Repositories.EmployeeRepository;
import org.randall.teagan.Repositories.GenderRepository;
import org.randall.teagan.Repositories.RaceRepository;
import org.randall.teagan.Services.ServiceInterfaces.FacadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class FacadeService implements FacadeServiceInterface {

    @Autowired
    EmployeeRepository empRepository = EmployeeRepository.getEmployeeRepository();
    @Autowired
    GenderRepository genderRepository = GenderRepository.getGenderRepository();
    @Autowired
    RaceRepository raceRepository = RaceRepository.getRaceRepository();
    @Autowired
    EmployeeFactory employeeFactory;
    @Autowired
    GenderFactory genderFactory;
    @Autowired
    RaceFactory raceFactory;

    private int genderHash;
    private int raceHash;

    public FacadeService(){}

    @Override
    public Employee saveEmployee(String empID, String empName, String empSurname, Gender gender, Race race){
        Employee employee = this.empRepository.create(EmployeeFactory.getEmployee(empID, empName, empSurname));
        gender = this.genderRepository.create(gender);
        race = this.raceRepository.create(race);
        genderHash = (gender.hashCode());
        raceHash = (race.hashCode());
        return employee;
    }

    @Override
    public Gender getEmployeeGender(String id){
        return this.genderRepository.read(id);
    }

    @Override
    public Race getEmployeeRace(String id){
        Race race = this.raceRepository.read(id);
        return race;
    }

    public int getGenderHash() {
        return genderHash;
    }

    public int getRaceHash() {
        return raceHash;
    }

    public void removeAll() {
        this.empRepository.removeAll();
        this.genderRepository.removeAll();
        this.raceRepository.removeAll();
    }
}
