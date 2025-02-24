package com.shilpi.app.module;

import java.io.Serializable;

public class Car {



    private String ownerName;
    private String registrationNumber;
    private String modelNumber;
    private String fuelType;

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getModelNumber() {
        return modelNumber;
    }
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public Car(String ownerName, String registrationNumber, String modelNumber, String fuelType) {
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
        this.modelNumber = modelNumber;
        this.fuelType = fuelType;
    }
    public Car() {}
}
