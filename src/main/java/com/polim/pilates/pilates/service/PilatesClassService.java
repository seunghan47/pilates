package com.polim.pilates.pilates.service;

import org.springframework.stereotype.Service;

@Service
public class PilatesClassService {
    private final PilatesClassRepository classRepository;

    public ClassService(PilatesClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<PilatesClass> findAllAvailableClasses() {
        return classRepository.findAll();
    }
}
