package com.shilpi.app.module;
import java.time.LocalDateTime;
public class ParkingEnd {
    private String slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private  int price;
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
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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

    public ParkingEnd(String slotNumber, LocalDateTime entryTime, LocalDateTime exitTime, int price, String currentStatus, String registrationNumber) {
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.price = price;
        this.currentStatus = currentSStatus;
        this.registrationNumber = registrationNumber;
    }

    public ParkingEnd() {}
}
