package com.shilpi.app.model;


public class Patient {

    private String name;
    private int age;
    private int id;
    private String patientGender; //M -> male,F -> female,O -> other
    private String hospitalName;


    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient(String name, int age, int id, String patientGender, String hospitalName) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.patientGender = patientGender;
        this.hospitalName = hospitalName;
    }
}
