package com.polim.pilates.pilates.service;

import com.polim.pilates.pilates.entity.Instructor;
import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.repository.PilatesClassRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PilatesClassService {
    private final PilatesClassRepository pilatesClassRepository;

    public PilatesClassService(PilatesClassRepository classRepository) {
        this.pilatesClassRepository = classRepository;
    }

   public PilatesClass saveClass(String instructor, LocalDateTime startTime, int capacity, String name) {
        if (capacity < 1) throw new IllegalArgumentException("enter a capacity greater than 0");

       Optional<PilatesClass> existingClass = pilatesClassRepository.findByStartTime(startTime);
       if (existingClass.isPresent()) {
           throw new IllegalStateException("this time is already taken up!");
       }

        PilatesClass newClass = new PilatesClass();
       newClass.setName(name);
        newClass.setInstructor(instructor);
        newClass.setStartTime(startTime);
        newClass.setCapacity(capacity);

       return pilatesClassRepository.save(newClass);
   }
}
