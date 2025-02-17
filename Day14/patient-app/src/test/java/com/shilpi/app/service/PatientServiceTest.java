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
    public void testGetPatient(){

        Patient patient1 = new Patient("Hari",67,1,"M","hospital1");
        Patient patient2 = new Patient("Fel",27,2,"F","hospital2");
        Patient patient3 = new Patient("John",47,3,"M","hospital1");

        //inserting data into map

        patientService.add(patient1);
        patientService.add(patient2);
        patientService.add(patient3);

        Map<Integer, Patient> resultPatientMap = patientService.getPatient();
        assert resultPatientMap.size() == 3;
        assert resultPatientMap.get(patient1.getId()) == patient1;
        assert resultPatientMap.get(patient2.getId()) == patient2;
        assert resultPatientMap.get(patient3.getId()) == patient3;




    }

    @Test
    public void testAdd(){
        Patient patient = new Patient("Fel",27,2,"F","hospital2");
        Patient resultPatient = patientService.add(patient);
        assert  resultPatient != null;
        assert resultPatient.getId()  == patient.getId();
        assert resultPatient.getId() == patient.getId();
        assert resultPatient.getAge() == patient.getAge();
        assert resultPatient.getHospitalName().equals(patient.getHospitalName());
        assert resultPatient.getName().equals(patient.getName());
        assert resultPatient.getPatientGender().equals(patient.getPatientGender());


    }

    @Test
    public void testUpdate(){

        Patient oldPatient = new Patient("Fel",27,2,"F","hospital2");
        Patient newPatient = patientService.add(oldPatient);

        Patient resultPatient = patientService.update(oldPatient.getId(),"newHospital2");
        assert resultPatient != null;
        assert resultPatient.getId() == newPatient.getId();
        assert resultPatient.getAge() == newPatient.getAge();
        assert resultPatient.getHospitalName().equals(newPatient.getHospitalName());
        assert resultPatient.getName().equals(newPatient.getName());
        assert resultPatient.getPatientGender().equals(newPatient.getPatientGender());
    }

    @Test
    public void testDelete(){
        Patient oldPatient = new Patient("Fel",27,2,"F","hospital2");
        Patient createdPatient = patientService.add(oldPatient);
        patientService.delete(createdPatient.getId());
        Map<Integer, Patient> resultPatient = patientService.getPatient();
        //resultPatient.put(oldPatient.getId(),oldPatient);
        assert  resultPatient.get(oldPatient.getId()) == null;

    }
}
