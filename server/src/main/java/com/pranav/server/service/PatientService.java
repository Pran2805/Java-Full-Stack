package com.pranav.server.service;

import com.pranav.server.dto.Request.PatientSignupReqDto;
import com.pranav.server.dto.Response.PatientSignupResDto;
import com.pranav.server.entity.Patient;
import com.pranav.server.entity.User;
import com.pranav.server.entity.type.RoleType;
import com.pranav.server.repository.PatientRepository;
import com.pranav.server.repository.UserRepository;
import com.pranav.server.utility.auth.BcryptUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private PatientRepository repo;
    private UserRepository userRepo;

    @Transactional // transaction save
    public Patient getPatientById(String Id) {
        return repo.findById(Id).orElseThrow();
    }

    public PatientSignupResDto signup(PatientSignupReqDto req) {

        if (repo.findByEmail(req.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        Patient patient = new Patient();
        User user = new User();

        patient.setFirstName(req.getFirstName());
        patient.setLastName(req.getLastName());
        patient.setEmail(req.getEmail());
        patient.setDob(req.getDob());
        patient.setGender(req.getGender());
        patient.setPhone(String.valueOf(req.getPhone()));
        patient.setAddress(req.getAddress());
        patient.setBloodGroup(req.getBloodGroup());

        Patient savedPatient = repo.save(patient);

        user.setEmail(req.getEmail());
        user.setUsername(req.getUsername());
        user.setPassword(BcryptUtil.hashPassword(req.getPassword()));
        user.setRole(RoleType.PATIENT);
        User savedUser = userRepo.save(user);

        PatientSignupResDto res = new PatientSignupResDto();

        res.setId(savedPatient.getId());

        res.setFirstName(savedPatient.getFirstName());
        res.setLastName(savedPatient.getLastName());

        res.setUsername(savedUser.getUsername());
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
