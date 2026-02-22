package com.pranav.server.dto.Response;

import com.pranav.server.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientSignupResDto {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private LocalDate dob;
    private String gender;
    private Long phone;

    private String address;
    private BloodGroupType bloodGroup;
    private LocalDateTime createdAt;

//    todo: token
}
