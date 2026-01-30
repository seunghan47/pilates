package com.polim.pilates.pilates.controller;

import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.service.PilatesClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class PilatesClassController {

    private final PilatesClassService classService;

    public PilatesClassController(PilatesClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/get")
    public List<PilatesClass> getAllClasses() {
        return classService.findAllAvailableClasses();
    }
}
