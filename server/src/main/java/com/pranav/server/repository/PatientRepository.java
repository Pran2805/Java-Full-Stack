package com.pranav.server.repository;

import com.pranav.server.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// model properties give by repository
@Repository // not mandatory to give repository annotation
public interface PatientRepository extends JpaRepository<Patient, String> {

    boolean findByEmail(String email);

    Optional<Patient> findByPhone(Long phone);

}
