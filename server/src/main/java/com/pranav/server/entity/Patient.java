package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

// model
@Entity
@ToString
@Getter
@Setter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
        },
        indexes = {
                @Index(name = "idx_patient_appointment", columnList = "appointment")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String lastName;

    private String email; // unique

    private LocalDate dob;

    private String gender;

    private Long phone;

    private String address;

    //todo: link to appoinment table
//    private Appointment appointment; // reference to new table

}
