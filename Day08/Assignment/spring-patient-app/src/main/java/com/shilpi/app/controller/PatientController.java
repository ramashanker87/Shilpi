package com.shilpi.app.controller;

import com.shilpi.app.model.Patient;
import com.shilpi.app.service.PatientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/age/all")
    public Map<String, Patient> getAllPatient() {
        return patientService.readAllPatients();}

    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestParam("id") String id,@RequestParam("Hospital Name") String hname) {
        return patientService.update(id,hname);
    }

    @DeleteMapping("/delete")
    public void deletePatient(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }
}
