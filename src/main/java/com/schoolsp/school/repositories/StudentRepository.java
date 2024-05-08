package com.schoolsp.school.repositories;

import com.schoolsp.school.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
