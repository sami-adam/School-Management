package com.schoolsp.school.controllers;

import com.schoolsp.school.models.Student;
import com.schoolsp.school.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/registerStudent")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Student> registerStudent(@Valid @RequestBody Student student){
        return ResponseEntity.ok(studentService.registerStudent(student));
    }
}
