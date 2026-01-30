package com.polim.pilates.pilates.service;

import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.repository.PilatesClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilatesClassService {
    private final PilatesClassRepository classRepository;

    public PilatesClassService(PilatesClassRepository classRepository) {
        this.classRepository = classRepository;
    }


    public List<PilatesClass> findAllAvailableClasses() {
        return classRepository.findAll();
    }
}
