package com.polim.pilates.pilates.controller;

import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.service.PilatesClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class PilatesClassController {

    private final PilatesClassService pilatesClassService;

    public PilatesClassController(PilatesClassService classService) {
        this.pilatesClassService = classService;
    }

    @GetMapping("/get")
    public List<PilatesClass> getAllClasses() {
        return null;
    }

    ////yyyy-MM-dd'T'HH:mm:ss.sss
    @PostMapping("/register")
    public PilatesClass registerClass(@RequestBody PilatesClass pilatesClass) {
            return pilatesClassService.saveClass(
                    pilatesClass.getInstructor(),
                    pilatesClass.getStartTime(),
                    pilatesClass.getCapacity(),
                    pilatesClass.getName());
    }

    @GetMapping("/search")
    public List<PilatesClass> searchByInstructor(@RequestParam String instructor) {
        return pilatesClassService.getClassesByTeacher(instructor);
    }

    @GetMapping("/available")
    public List<PilatesClass> getAvailable() {
        return pilatesClassService.getAvailableClasses();
    }
}