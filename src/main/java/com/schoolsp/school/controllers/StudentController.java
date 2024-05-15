package com.schoolsp.school.controllers;

import com.schoolsp.school.dto.StudentDTO;
import com.schoolsp.school.models.Student;
import com.schoolsp.school.security.jwt.JwtUtils;
import com.schoolsp.school.services.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.registerStudent(studentDTO));
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }
}
