package com.schoolsp.school.services;

import com.schoolsp.school.models.Student;
import com.schoolsp.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return studentRepository.findAll().stream().toList();
    }
    @PreAuthorize("hasRole('USER')")
    public Student registerStudent(Student student){
        studentRepository.save(student);
        return student;
    }
}
