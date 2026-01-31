package com.polim.pilates.pilates.repository;

import com.polim.pilates.pilates.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
