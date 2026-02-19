package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String diagnosis;
    private String notes;

//
//    private Appointment appointment;
//    private Medicine medicine;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
