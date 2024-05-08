package com.schoolsp.school.repositories;

import com.schoolsp.school.models.ERole;
import com.schoolsp.school.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
