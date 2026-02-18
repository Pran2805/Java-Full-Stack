package com.pranav.server.repository;

import com.pranav.server.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// model properties give by repository
@Repository // not mandatory to give repository annotation
public interface PatientRepository extends JpaRepository<Patient, String> {

}
