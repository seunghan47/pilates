package com.polim.pilates.pilates.entity;

import jakarta.persistence.*;
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
    private String name; // e.g., "Advanced Reformer"

    @Column(nullable = false)
    private String instructor;

    //yyyy-MM-dd'T'HH:mm:ss.sss
    private LocalDateTime startTime;

    private Integer capacity;

    @ManyToMany(mappedBy = "enrolledClasses")
    private List<Member> enrolledMembers = new ArrayList<>();
}
