package com.shilpi.app.module;

import java.time.LocalDateTime;

public class ParkingEnd {
    private String parkingNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private  int price;
    private String status;
    private String registrationNumber;

    public String getParkingNumber() {
        return parkingNumber;
    }
    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ParkingEnd(String parkingNumber, LocalDateTime startTime, LocalDateTime endTime, int price, String status, String registrationNumber) {
        this.parkingNumber = parkingNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.status = status;
        this.registrationNumber = registrationNumber;
    }

    public ParkingEnd() {}
}
