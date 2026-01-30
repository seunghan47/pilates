package com.polim.pilates.pilates.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class PilatesClassController {

    private final ClassService classService;

    public PilatesClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<PilatesClass> getAllClasses() {
        return classService.findAllAvailableClasses();
    }
}
