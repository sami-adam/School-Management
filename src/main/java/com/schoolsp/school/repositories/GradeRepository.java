package com.schoolsp.school.repositories;

import com.schoolsp.school.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
