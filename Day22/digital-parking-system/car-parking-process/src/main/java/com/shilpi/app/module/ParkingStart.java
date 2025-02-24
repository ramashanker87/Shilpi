package com.shilpi.app.module;

import java.time.LocalDateTime;


public class ParkingStart {
    private String parkingNo;
    private LocalDateTime startTime;
    private String status;
    private String registrationNo;

    public String getParkingNo() {
        return parkingNo;
    }
    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRegistrationNo() {
        return registrationNo;
    }
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public ParkingStart(String parkingNo, LocalDateTime startTime, String status, String registrationNo) {
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.status = status;
        this.registrationNo = registrationNo;
    }
    public ParkingStart() {}
}
