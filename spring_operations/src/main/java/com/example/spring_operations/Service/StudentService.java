package com.example.spring_operations.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_operations.Model.Student;
import com.example.spring_operations.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingData = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

                existingData.setName(updatedStudent.getName());
                existingData.setContact(updatedStudent.getContact());
                existingData.setAddress(updatedStudent.getAddress());
        
        return studentRepository.save(existingData);
    }
    
    
}
