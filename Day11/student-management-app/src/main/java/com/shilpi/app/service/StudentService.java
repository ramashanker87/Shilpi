package com.ajay.app.service;

import com.ajay.app.model.Student;
import com.ajay.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String saveStudent( Student student) {
        studentRepository.save(student);
        return student.getName()+ " is saved to the database";
    }
}
