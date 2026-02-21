package com.pranav.server.controller.auth;

import com.pranav.server.dto.Request.PatientSignupReqDto;
import com.pranav.server.dto.Response.PatientSignupResDto;
import com.pranav.server.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient/signup")
    public ResponseEntity<PatientSignupResDto> PatientSignup(@RequestBody PatientSignupReqDto body){
        PatientSignupResDto res = patientService.signup(body);
        return ResponseEntity.ok(res);
    }
}
