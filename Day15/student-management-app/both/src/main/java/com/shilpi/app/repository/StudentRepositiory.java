package com.shilpi.app.repository;

import com.shilpi.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositiory extends JpaRepository<Student, Integer> {
    Student getByName(String name);

    Student findByName(String name);
}
