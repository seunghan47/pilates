package com.polim.pilates.pilates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class PilatesClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "class name is required! ")
    private String name; // e.g., "Advanced Reformer"

    @Column(nullable = false)
    private String instructor;

    //yyyy-MM-dd'T'HH:mm:ss.sss
    @NotNull(message = "Start time is required")
    @Future(message = "Class date must be in the future")
    private LocalDateTime startTime;

    @Min(value = 1, message = "Capacity must be at least 1")
    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @ManyToMany(mappedBy = "enrolledClasses")
    @JsonIgnoreProperties("enrolledClasses")
    private List<Member> enrolledMembers = new ArrayList<>();
}
