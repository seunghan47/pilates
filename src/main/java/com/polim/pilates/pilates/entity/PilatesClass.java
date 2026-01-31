package com.polim.pilates.pilates.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class PilatesClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name; // e.g., "Advanced Reformer"
    private String instructor;
    private LocalDateTime startTime;
    private Integer capacity;

}
