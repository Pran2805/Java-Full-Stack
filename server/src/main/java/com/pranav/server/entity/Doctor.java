package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(
        indexes = {
                @Index(name = "idx_patient_appointment", columnList = "appointment")
        }
)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private Long phone;
    private String specialization;

    // todo: add many to many many to one relation
//    private Department department;
//    private List<Appointment> appointment;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
