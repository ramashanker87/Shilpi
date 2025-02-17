package com.shilpi.app.controller;

import com.shilpi.app.model.Patient;
import com.shilpi.app.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;
    @Mock
    private PatientService patientService;

    @Test
    public void testGetAllPatient(){

        //Temporary data for testing
        Map<Integer, Patient> PatientTestMap = new HashMap<>();
        Patient patient1 = new Patient("Hari",67,1,"M","hospital1");
        Patient patient2 = new Patient("Fel",27,2,"F","hospital2");
        Patient patient3 = new Patient("John",47,3,"M","hospital1");

        //inserting data into map
        PatientTestMap.put(patient1.getId(), patient1 );
        PatientTestMap.put(patient2.getId(), patient2);
        PatientTestMap.put(patient3.getId(), patient3);

        when(patientService.getPatient()).thenReturn(PatientTestMap);

        Map<Integer, Patient> resultPatientMap =patientController.getAllPatient();
        assert resultPatientMap != null;
        assert resultPatientMap.size() ==3;
        assert resultPatientMap.get(patient1.getId()) == patient1;
        assert resultPatientMap.get(patient2.getId()) == patient2;
        assert resultPatientMap.get(patient3.getId()) == patient3;

    }

    @Test
    public void testSavePatient(){
        Map<Integer, Patient> PatientTestMap = new HashMap<>();
        Patient patient1 = new Patient("Hari",67,1,"M","hospital1");
        PatientTestMap.put(patient1.getId(), patient1 );
        when(patientService.add(patient1)).thenReturn(patient1);

        Patient resultPatient = patientController.savePatient(patient1);
        assert resultPatient != null;
        assert PatientTestMap.size() ==1;
        assert resultPatient.getName().equals(patient1.getName());
        assert resultPatient.getAge() == patient1.getAge();
        assert resultPatient.getId() == patient1.getId();
        assert resultPatient.getPatientGender().equals(patient1.getPatientGender());
        assert resultPatient.getHospitalName().equals(patient1.getHospitalName());

    }

    @Test
    public void testUpdatePatient(){
        Patient oldPatient = new Patient("Fel",27,2,"F","hospital2");
        Patient newPatient = new Patient("Fel",27,2,"F","newHospital2");

        when(patientService.update(anyInt(),anyString())).thenReturn(newPatient);

        Patient resultPatient = patientController.updatePatient(oldPatient.getId(),"newHospital2");
        assert resultPatient != null;
        assert resultPatient.getId() == newPatient.getId();
        assert resultPatient.getAge() == newPatient.getAge();
        assert resultPatient.getHospitalName().equals(newPatient.getHospitalName());
        assert resultPatient.getName().equals(newPatient.getName());
        assert resultPatient.getPatientGender().equals(newPatient.getPatientGender());

    }

    @Test
    public void testDeletePatient(){
        when(patientService.delete(1)).thenReturn("Patient deleted");

        String response = patientController.deletePatient(1);


        assert  response !=null;
        assert response.equals("Patient deleted");


        verify(patientService, times(1)).delete(1);
    }


}
