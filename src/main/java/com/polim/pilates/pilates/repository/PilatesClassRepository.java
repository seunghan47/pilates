package com.polim.pilates.pilates.repository;

import com.polim.pilates.pilates.entity.PilatesClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PilatesClassRepository extends JpaRepository<PilatesClass, Long> {
    Optional<PilatesClass> findByStartTime(LocalDateTime startTime);
    List<PilatesClass> findByClassNameContainingIgnoreCase(String name);
    List<PilatesClass> findByStartTime(LocalDate date);

    List<PilatesClass> findByNameContainingIgnoreCase(String name);
    List<PilatesClass> findByInstructor(String instructor);

}
