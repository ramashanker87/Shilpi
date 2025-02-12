package com.shilpi.app.controller;

import com.shilpi.app.model.Student;
import com.shilpi.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public Iterable<Student> getStudents() {
        LOGGER.info("Received request to fetch all students");
        Iterable<Student> students = studentService.findAllStudents();
        LOGGER.info("Returning list of students: {}", students);
        return students;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        LOGGER.info("Received request to save student: {}", student);
        studentService.saveStudent(student);
        LOGGER.info("Student {} has been saved successfully", student.getName());
        return "Student " + student.getName() + " has been saved!";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestParam String name, @RequestParam int age) {
        LOGGER.info("Received request to update student with name: {} and age: {}", name, age);
        studentService.updateStudent(name, age);
        LOGGER.info("Student {} has been updated with age: {}", name, age);
        return "Student " + name + " has been updated with age: " + age;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String name) {
        LOGGER.info("Received request to delete student with name: {}", name);
        studentService.deleteStudent(name);
        LOGGER.info("Student {} has been deleted successfully", name);
        return "Student " + name + " has been deleted!";
    }
}
