package com.schoolsp.school.services;

import com.schoolsp.school.dto.StudentDTO;
import com.schoolsp.school.models.Student;
import com.schoolsp.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student: students){
            studentDTOS.add(new StudentDTO(
                    student.getFullName(),
                    student.getEmail(),
                    student.getUser(),
                    student.getDateOfBirth(),
                    student.getGrade(),
                    student.getSchool()
            ));
        }
        return studentDTOS;
    }
    @PreAuthorize("hasRole('USER')")
    public StudentDTO registerStudent(StudentDTO studentDto){
        Student student = new Student(
                studentDto.getEmail(),
                studentDto.getUser(),
                studentDto.getFullName(),
                studentDto.getDateOfBirth(),
                studentDto.getGrade(),
                studentDto.getSchool()
        );
        studentRepository.save(student);
        return studentDto;
    }

    @PreAuthorize("hasRole('USER')")
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO){
        Student dBstudent = studentRepository.findById(id).orElseThrow();
        if (studentDTO.getFullName() != null)
            dBstudent.setFullName(studentDTO.getFullName());
        if (studentDTO.getUser() != null)
            dBstudent.setUser(studentDTO.getUser());
        if (studentDTO.getDateOfBirth() != null)
            dBstudent.setDateOfBirth(studentDTO.getDateOfBirth());
        if (studentDTO.getGrade() != null)
            dBstudent.setGrade(studentDTO.getGrade());
        studentRepository.save(dBstudent);
        return studentDTO;
    }
}
