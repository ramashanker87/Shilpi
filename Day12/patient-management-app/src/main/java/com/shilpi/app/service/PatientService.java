package com.ajay.app.service;

import com.ajay.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map;

@Service
public class PatientService {
    Map<Integer, Patient> map = new HashMap<>();

    //get

    public Map<Integer, Patient> getPatient() {
        return map;
    }

    //getByAge
//    public Map<Integer, Patient> getPatient() {
//        return map;
//    }
    //add
    public Patient add(Patient patient){
        map.put(patient.getId(), patient);
        return patient;
    }
    //update
    public Patient update(int id, String hospitalName){
        Patient patient = map.get(id);
        patient.setHospitalName(hospitalName);
        return patient;
    }
    //remove

    public String delete(int id){
        Patient patient= map.get(id);
        map.remove(id);
        return "patient with id : "+id+", Name : "+patient.getName() +" is deleted";
    }

}

