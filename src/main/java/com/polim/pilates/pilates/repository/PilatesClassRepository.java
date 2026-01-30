package com.polim.pilates.pilates.repository;

import com.polim.pilates.pilates.entity.PilatesClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilatesClassRepository extends JpaRepository<PilatesClass, Long> {
    List<PilatesClass> findByType(String type);
    List<PilatesClass> findByEnrolledCountLessThan(int capacity);
}
