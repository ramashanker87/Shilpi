package com.shilpi.app.service;

import com.shilpi.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    PatientService PatientService=new PatientService();

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("1","P1","ABC Hospital", 30, "M");
        Patient expectedPatient=patientService.createPatient(patient);
        assert expectedPatient != null;
        assert expectedPatient.getId()== patient.getId();
        assert expectedPatient.getName()== patient.getName();
        assert expectedPatient.getHname()== patient.getHname();
        assert expectedPatient.getAge()== patient.getAge();
        assert expectedPatient.getGender()== patient.getName();
    }

    @Test
    public void testUpdatePatientHospital() {
        Patient patient = new Patient("1","P1","ABC Hospital", 30, "M");
        Patient expectedPatient=patientService.createPatient(patient);
        Patient resultPatient=patientService.updateHname("1","New Hospital");
        assert expectedPatient != null;
        assert expectedPatient.getId()== patient.getId();
        assert expectedPatient.getName()== patient.getName();
        assert expectedPatient.getHname()== "New Hospital";
        assert expectedPatient.getAge()== patient.getAge();
        assert expectedPatient.getGender()== patient.getName();
    }

    @Test
    public void testDeletePatient() {
        Patient Patient= new Patient("1","P1","ABC Hospital", 30, "M");
        Patient expectedPatient=patientService.createPatient(Patient);
        PatientService.deletePatient(patient.getName());
        Employee expectedResult=patientService.readPatientByName(Patient.getName());
        assert expectedResult== null;

    }
    @Test
    public void testReadEmployeesBYName() {
        Employee employee1 = new Employee("1","Emp1",25);
        Employee actualEmployee=employeeService.createEmployee(employee1);
        Employee expectedResult=employeeService.readEmployeeByName(employee1.getId());
        assert expectedResult != null;
        assert expectedResult.getId()== actualEmployee.getId();
        assert expectedResult.getName()== actualEmployee.getName();
        assert expectedResult.getAge()== actualEmployee.getAge();
    }
    @Test
    public void testReadAllEmployees() {
        Employee employee1 = new Employee("1","Emp1",25);
        Employee employee2 = new Employee("2","Emp2",26);
        Employee employee3 = new Employee("3","Emp3",27);
        employeeService.createEmployee(employee1);
        employeeService.createEmployee(employee2);
        employeeService.createEmployee(employee3);
        Map<String,Employee> resultEmployees= employeeService.readAllEmployee();
        assert resultEmployees.size()==3;
        assert resultEmployees.containsKey(employee1.getId());
        assert resultEmployees.containsKey(employee2.getId());
        assert resultEmployees.containsKey(employee3.getId());
    }
}
