package com.shilpi.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shilpi.app.module.Patient;
import com.shilpi.app.service.ReceiverDoctorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.utils.Pair;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class DoctorController {

    private final ReceiverDoctorService receiverDoctorService;
    @Value("${amazon.aws.sqs.queue}")
    private String queue;

    public DoctorController(ReceiverDoctorService receiverDoctorService) {
        this.receiverDoctorService = receiverDoctorService;
    }

    @GetMapping("/receive")
    public ResponseEntity<Patient> receive() throws InterruptedException, ExecutionException, JsonProcessingException {

        Pair<Patient, Map<String, MessageAttributeValue>> message = receiverDoctorService.consumeMessage(queue,Patient.class);
        Patient patient = message.left();

        Map<String, MessageAttributeValue> messageAttributes = message.right();

        HttpHeaders headers = new HttpHeaders();

        messageAttributes.forEach((key,value)->{
            if(value.stringValue()!=null){
                headers.add(key,value.stringValue());
            }
        });
        return new ResponseEntity<>(patient,headers, HttpStatus.ACCEPTED);

    }
}
