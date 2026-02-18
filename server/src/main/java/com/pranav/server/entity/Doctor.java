package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_doctor_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_doctor_phone", columnNames = {"phone"}),
        },
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
    private String email;
    private Long phone;
    private String specialization;
    private Department department;
    private List<Appointment> appointment;
}
