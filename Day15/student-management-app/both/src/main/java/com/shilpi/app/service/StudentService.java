package com.shilpi.app.service;

import com.shilpi.app.model.Student;
import com.shilpi.app.repository.StudentRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepositiory studentRepo;

    public Iterable<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public String saveStudent(Student student) {
         studentRepo.save(student);
         return student.getName() +" has been saved";
    }

    public String updateStudent(String name, int age) {
        Student student = studentRepo.findByName(name);
        student.setAge(age);
        studentRepo.save(student);
        return name +" has been updated";
    }

    public String deleteStudent(String name) {
        Student student = studentRepo.findByName(name);
        studentRepo.delete(student);
        return name +" has been deleted";
    }


}
