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
    PatientService patientService;

    @Test
    public void testCreatePatients() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient expectedPatient=patientService.createPatient(p1);
        assert expectedPatient != null;
        assert expectedPatient.getId()== p1.getId();
        assert expectedPatient.getName()== p1.getName();
        assert expectedPatient.getAge()== p1.getAge();
    }

    @Test
    public void testUpdatePatient() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient expectedPatient=patientService.createPatient(p1);
        assert expectedPatient != null;
        assert expectedPatient.getId()== p1.getId();
        assert expectedPatient.getName()== p1.getName();
        assert expectedPatient.getAge()==25;
    }

    @Test
    public void testDeletePatient() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient expectedPatient=patientService.createPatient(p1);
        patientService.deletePatient(p1.getName());
        Patient expectedResult=patientService.readPatientByName(p1.getName());
        assert expectedResult== null;

    }
    @Test
    public void testReadPatientsBYName() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient actualPatient=patientService.createPatient(p1);
        Patient expectedResult=patientService.readPatientByName(p1.getId());
        assert expectedResult != null;
        assert expectedResult.getId()== actualPatient.getId();
        assert expectedResult.getName()== actualPatient.getName();
        assert expectedResult.getAge()== actualPatient.getAge();
    }
    @Test
    public void testReadAllPatients() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient p2 = new Patient("p2","2","B",21,"M");
        Patient p3 = new Patient("p3","3","C",43,"M");
        patientService.createPatient(p1);
        patientService.createPatient(p2);
        patientService.createPatient(p3);
        Map<String,Patient> result= patientService.readAllPatients();
        assert result.size()==3;
        assert result.containsKey(p1.getId());
        assert result.containsKey(p2.getId());
        assert result.containsKey(p3.getId());
    }
}



