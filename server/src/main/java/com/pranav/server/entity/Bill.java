package com.pranav.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Float totalAmount;
    private Float paid;
    private LocalDate billDate;
    private Patient patient;
}

// todo (optional): If possible add payment functionality here using payment entity