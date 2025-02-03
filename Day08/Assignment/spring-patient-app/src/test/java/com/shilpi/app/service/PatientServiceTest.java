package com.shilpi.app.service;

import com.shilpi.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.*;

import java.util.Map;


public class PatientServiceTest {
    @InjectMocks
    PatientService patientService=new PatientService();

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("1","P1","ABC Hospital", 30, "M");
        Patient result=patientService.createPatient(patient);
        assert result!=null;
        assertEquals("P1",result.getName());
    }

    @Test
    public void testUpdatePatientHospital() {
        Patient patient = new Patient("1","P1","ABC Hospital", 30, "M");
        patientService.createPatient(patient);
        patientService.updateHname("1","XYZ Hospital");
        assertEquals("XYZ Hospital", patientService.getAllPatients().get("1").getHname());
    }

    @Test
    public void testDeletePatient() {
        Patient patient = new Patient("1", "P1", "ABC Hospital", 30, "M");
        patientService.createPatient(patient);
        PatientService.deletePatient("1");
        assertNull(patientService.getAllPatients().get("1"));
    }

    @Test
    public void testGetAllPatients() {
        Patient patient1 = new Patient("1", "P1", "ABC Hospital", 30, "M");
        Patient patient2 = new Patient("2", "P2", "XYZ Hospital", 28, "F");
        patientService.createPatient(patient1);
        PatientService.createPatient(patient2);
        assertEquals(2,patientService.getAllPatients().size());
    }
}
