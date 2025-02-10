package com.shilpi.app.controller;

import com.shilpi.app.model.Patient;
import com.shilpi.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public Map<Integer, Patient> getAllPatient(){
        return patientService.getPatient();
    }

    @GetMapping("/age/all")
    public void getAllPatientWithSpecificAge(@RequestParam int age){

    }

    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.add(patient);
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestParam int id, @RequestParam String hospitalName){
        return patientService.update(id, hospitalName);
    }

    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam int id){
        return patientService.delete(id);
    }



}
