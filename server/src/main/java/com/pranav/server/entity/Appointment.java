package com.pranav.server.entity;

import com.pranav.server.entity.type.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@ToString
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private StatusType status;

//    private Doctor doctor;
//    private Patient patient;
//    private Prescription prescription;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}

