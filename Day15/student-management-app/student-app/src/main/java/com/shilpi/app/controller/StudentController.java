package com.shilpi.app.controller;


import com.shilpi.app.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private RestTemplate restTemplate;

    private static final String SCHOOL_OPERATION_URL = "http://localhost:8099/school";  // School-Operation Service URL

    @GetMapping("/all")
    public Iterable<Student> getStudents() {
        LOGGER.info("Sending request to get all students from {}", SCHOOL_OPERATION_URL + "/all");
        Iterable<Student> response = restTemplate.getForObject(SCHOOL_OPERATION_URL + "/all", Iterable.class);
        LOGGER.info("Response received from school-operation: {}", response);
        return response;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        LOGGER.info("Sending request to save student: {}", student);
        String response = restTemplate.postForObject(SCHOOL_OPERATION_URL + "/save", student, String.class);
        LOGGER.info("Response received from school-operation: {}", response);
        return "Response from School-Operation: " + response;
    }

    @PutMapping("/update")
    public String updateStudent(@RequestParam String name, @RequestParam int age) {
        LOGGER.info("Sending request to update student with name: {} and age: {}", name, age);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                SCHOOL_OPERATION_URL + "/update?name=" + name + "&age=" + age,
                HttpMethod.PUT,
                entity,
                String.class
        );

        LOGGER.info("Response received from school-operation: {}", response.getBody());
        return "Response from School-Operation: " + response.getBody();
    }


    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String name) {
        LOGGER.info("Sending request to delete student with name: {}", name);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);  // No body needed for DELETE

        ResponseEntity<String> response = restTemplate.exchange(
                SCHOOL_OPERATION_URL + "/delete?name=" + name,
                HttpMethod.DELETE,
                entity,
                String.class
        );

        LOGGER.info("Response received from school-operation: {}", response.getBody());
        return "Response from School-Operation: " + response.getBody();
    }
}


