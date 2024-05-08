package com.schoolsp.school.repositories;

import com.schoolsp.school.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
