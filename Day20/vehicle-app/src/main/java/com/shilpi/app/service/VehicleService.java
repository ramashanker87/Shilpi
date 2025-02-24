package com.shilpi.app.service;

import com.shilpi.app.module.Owner;
import com.shilpi.app.module.Registration;
import com.shilpi.app.module.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleService {
    private final Logger logger = LoggerFactory.getLogger(VehicleService.class);
    Map<String, Registration> map = new HashMap<>();

    public String saveVehicle(Vehicle vehicle, Owner owner) {
        logger.info("Vehicle registration started : " + vehicle + " owner : " + owner);
        String vehicleNum = vehicle.getVehicleNumber();
        logger.info("Registering the vehicle .......");
        map.put(vehicleNum,new Registration(vehicle,owner));
        logger.info("Vehicle registration completed : {} owner : {}", vehicle, owner);
        return owner.getName()+" your vehicle "+vehicleNum+" is registered";
    }

    public String deleteVehicle(String vehicleNumber) {
        logger.info("Vehicle de-registration started for vehicle number : {}", vehicleNumber);
        map.remove(vehicleNumber);
        logger.info("Vehicle de-registration completed successfully for vehicle number : {}", vehicleNumber);
        return vehicleNumber+" has been de-registered Successfully";
    }

    public List<Registration> getAllVehicles() {
        logger.info("generating vehicle list");
        return new ArrayList<>(map.values());
    }

}
