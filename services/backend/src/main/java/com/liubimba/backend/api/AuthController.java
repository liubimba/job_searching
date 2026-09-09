package com.liubimba.backend.api;

import com.liubimba.backend.dto.ApplicantDTO;
import com.liubimba.backend.dto.SignUpDTO;
import com.liubimba.backend.exception.UserMailExistsException;
import com.liubimba.backend.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    UserService userService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }


    @PostMapping("sign_up")
    public ResponseEntity<Void> signUpApplicant(@Validated SignUpDTO dto) {
        ApplicantDTO applicantDTO = new ApplicantDTO();
        applicantDTO.setEmail(dto.getEmail());
        applicantDTO.setPassword(passwordEncoder.encode(dto.getPassword()));
        try {
            applicantService.register(applicantDTO);
        } catch (UserMailExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok().build();
    }
}
