package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(scale = 4)
    private Float totalAmount;

    @Column(scale = 4)
    private Float paid;

    private LocalDate billDate;

//    private Patient patient;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}

// todo (optional): If possible add payment functionality here using payment entity