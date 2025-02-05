package com.shilpi.app.service;

import org.springframework.stereotype.Service;
import com.shilpi.app.model.Patient;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class PatientService {
    Map<String, Patient> patients = new HashMap<String, Patient>();

    public Patient createPatient(Patient patient) {
        patients.put(patient.getId(),patient);
        return patient;
    }

    public Patient updatePatient(String hospitalName, String newHospitalName) {
        Patient p1= patients.get(hospitalName);
        p1.setHospitalName(newHospitalName);
        return p1;
    }

    public void deletePatient(String id) {
        patients.remove(id);
    }

    public Patient readPatientByName(String name) {
        Patient result=patients.get(name);
        return result;
    }
    public Map<String,Patient> readAllPatients() {
        return patients;
    }
}


