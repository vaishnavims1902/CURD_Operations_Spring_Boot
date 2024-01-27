package com.example.spring_operations.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.spring_operations.Model.Student;
import com.example.spring_operations.Repository.StudentRepository;
import com.example.spring_operations.Service.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String first(){
        return "Welcome to Students Information Portal!";
    }
    
    @PostMapping("/register")
    public String addUser(@RequestBody Student student) {
  
        studentRepo.save(student);
       return "Student Registered";
    }

    @GetMapping("/getStudentById/{stdId}")
    public Optional<Student> getStudentById(@PathVariable int stdId) {
        return studentRepo.findById(stdId);
    }
    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/deleteStudentById/{stdId}")
    public String deleteStudentById(@PathVariable int stdId,Model model)
    {
        studentRepo.deleteById(stdId);
        return "Student Deleted!";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student updatedEntity = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(updatedEntity);
    }
    
}
