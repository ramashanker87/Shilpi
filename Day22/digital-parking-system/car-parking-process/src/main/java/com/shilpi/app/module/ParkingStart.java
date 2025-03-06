package com.shilpi.app.module;

import java.time.LocalDateTime;


public class ParkingStart {
    private String slotNumber;
    private LocalDateTime entryTime;
    private String currentStatus;
    private String registrationNumber;

    public String getSlotgNumber() {
        return slotNumber;
    }
    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public String getCurrentStatus() {
        return currentStatus;
    }
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ParkingStart(String slotNumber, LocalDateTime entryTime, String currentStatus, String registrationNumber) {
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.currentStatus = currentStatus;
        this.registrationNumbe = registrationNumbe;
    }
    public ParkingStart() {}
}
