package com.example.spring_operations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_operations.Model.Student;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findById(int id);
    Student deleteById(int id);
}
