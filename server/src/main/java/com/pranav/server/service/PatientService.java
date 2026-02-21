package com.pranav.server.service;

import com.pranav.server.dto.Request.PatientSignupReqDto;
import com.pranav.server.dto.Response.PatientSignupResDto;
import com.pranav.server.entity.Patient;
import com.pranav.server.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private PatientRepository repo;

    @Transactional // transaction save
    public Patient getPatientById(String Id) {
        return repo.findById(Id).orElseThrow();
    }

    public PatientSignupResDto signup(PatientSignupReqDto req) {

        if (repo.findByEmail(req.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        Patient patient = new Patient();
        patient.setFirstName(req.getFirstName());
        patient.setLastName(req.getLastName());
        patient.setEmail(req.getEmail());
        patient.setDob(req.getDob());
        patient.setGender(req.getGender());
        patient.setPhone(String.valueOf(req.getPhone()));
        patient.setAddress(req.getAddress());
        patient.setBloodGroup(req.getBloodGroup());

        Patient savedPatient = repo.save(patient);

        PatientSignupResDto res = new PatientSignupResDto();

        res.setId(savedPatient.getId());
        res.setFirstName(savedPatient.getFirstName());
        res.setLastName(savedPatient.getLastName());
        res.setEmail(savedPatient.getEmail());
        res.setDob(savedPatient.getDob());
        res.setGender(savedPatient.getGender());
        res.setPhone(Long.valueOf(savedPatient.getPhone()));
        res.setAddress(savedPatient.getAddress());
        res.setBloodGroup(savedPatient.getBloodGroup());
        res.setCreatedAt(savedPatient.getCreatedAt());

        return res;
    }
}
