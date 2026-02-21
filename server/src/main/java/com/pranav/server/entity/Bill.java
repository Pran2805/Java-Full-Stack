package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(scale = 4)
    private Float totalAmount;

    @Column(scale = 4)
    private Float paid;

    private Float dueAmount; // Added for convenience

    private LocalDate billDate;

    // Many bills belong to one patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; // Changed from comment

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // Helper method to calculate due amount
    @PrePersist
    @PreUpdate
    private void calculateDue() {
        if (totalAmount != null && paid != null) {
            this.dueAmount = totalAmount - paid;
        }
    }
}