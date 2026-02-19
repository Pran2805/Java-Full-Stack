package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;
    private String dosage;
    private int frequency;
    private int durationInDays;

//    private Prescription prescription;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
