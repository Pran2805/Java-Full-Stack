package com.pranav.server.service;

import com.pranav.server.entity.Patient;
import com.pranav.server.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional // transaction save
    public Patient getPatientById(String Id) {
        return patientRepository.findById(Id).orElseThrow();
    }
}
