package com.shilpi.app.module;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String fuelType;


    private final Logger logger = LoggerFactory.getLogger(Vehicle.class);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public Vehicle(){

        logger.trace("TRACE Level Log for Vehicle Constructor");
        logger.debug("DEBUG Level Log for Vehicle Constructor");
        logger.info("INFO Level Log for Vehicle Constructor");
        logger.warn("WARN Level Log for Vehicle Constructor");
        logger.error("ERROR Level Log for Vehicle Constructor");


    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
