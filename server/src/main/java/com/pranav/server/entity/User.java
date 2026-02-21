package com.pranav.server.entity;

import com.pranav.server.entity.type.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean isValid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role; // Changed from 'roles' to 'role' (singular)

    // One-to-One with Doctor (if user is a doctor)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", unique = true)
    private Doctor doctor; // Added: Links to doctor if role is DOCTOR

    // One-to-One with Patient (if user is a patient)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", unique = true)
    private Patient patient; // Added: Links to patient if role is PATIENT

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}