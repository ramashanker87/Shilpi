package com.shilpi.app.controller;

import com.shilpi.app.module.Car;
import com.shilpi.app.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private static final Logger log = LoggerFactory.getLogger(ParkingController.class);
    @Autowired
    private ParkingService parkingService;
    @PostMapping("/start")
    public String startParking(@RequestBody Car car, @RequestParam String slotNumber) {
        log.info("Received parking start request for car: {}", car);
        return parkingService.parkingStartService(car, slotNumber);
    }
    @DeleteMapping("/end")
    public String endPparking( @RequestParam String slotNumber) {
        log.info("Received parking end request for car:  {}", slotNumber);
        return parkingService.parkingEndService(slotNumber);
    }
}
