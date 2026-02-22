package com.pranav.server.dto.Request;

import com.pranav.server.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientSignupReqDto {
    private String firstName;
    private String lastName;

    private String username;

    private String email;
    private String password;

    private LocalDate dob;
    private String gender;
    private Long phone;

    private String address;
    private BloodGroupType bloodGroup;
}
