package com.pranav.server.entity;

import com.pranav.server.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDate dob;

    private String gender;

    @Column(nullable = false, length = 10)
    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bill> bills = new ArrayList<>();

    // One-to-One with User (reverse relationship)
    @OneToOne(mappedBy = "patient", fetch = FetchType.LAZY)
    private User user; // Added: Links back to user account

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}