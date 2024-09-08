package com.user.manager.controller;

import com.user.manager.Dto.JwtAuthResponse;
import com.user.manager.Dto.LoginDto;
import com.user.manager.Dto.SignUpDto;
import com.user.manager.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        JwtAuthResponse response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody SignUpDto signUpDto) {
        String response = authService.signUp(signUpDto);
        return ResponseEntity.ok(response);
    }
}