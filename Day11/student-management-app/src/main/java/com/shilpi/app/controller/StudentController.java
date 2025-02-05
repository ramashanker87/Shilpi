package com.shilpi.app.controller;

import com.shilpi.app.model.Student;
import com.shilpi.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value ="/read", method= RequestMethod.GET)
    public Iterable<Student> readAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value ="/save", method= RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
