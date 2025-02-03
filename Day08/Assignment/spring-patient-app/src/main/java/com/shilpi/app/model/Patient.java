package com.shilpi.app.model;

public class Patient {
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getHname() {
        return hname;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {return gender;}
    public void setHname(String hname) {
        this.hname = hname;
    }

    String id;
    String name;
    String hname;
    int age;
    String gender;
    public Patient(String id, String name, String hname, int age, String gender) {
        super();
        this.id = id;
        this.name = name;
        this.hname=hname;
        this.age = age;
        this.gender=gender;
    }

}
