package com.shilpi.app.service;

import com.shilpi.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patientMap = new HashMap<>();

    public Patient createPatient(Patient patient) {
        patientMap.put(patient.getId(),patient);
        return patient;
    }

    public Patient updateHname(String id, String newHname) {
        Patient patient= patientMap.get(id);
        if(patient!=null) {
            patient.setHname(newHname);
        }
        return patient;
    }

    public void deletePatient(String id) {
        patientMap.remove(id);
    }

    public Map<String,Patient> getAllPatients() {
        return patientMap;
    }
}
