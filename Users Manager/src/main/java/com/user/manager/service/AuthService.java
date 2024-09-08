package com.user.manager.service;


import com.user.manager.Dto.JwtAuthResponse;
import com.user.manager.Dto.LoginDto;
import com.user.manager.Dto.SignUpDto;
import com.user.manager.enums.Role;
import com.user.manager.jwt.JwtTokenProvider;
import com.user.manager.model.User;
import com.user.manager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println("token"+token);
        User user = userRepository.findByUsernameOrEmail(loginDto.getUserNameOrEmail(), loginDto.getUserNameOrEmail());
        System.out.println("user"+user);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setAccessToken(token);
        response.setTokenType("Bearer");
        response.setUserName(user.getUsername());
        response.setRole(String.valueOf(user.getRole()));
        response.setPersonId(user.getUserId());
        System.out.println("response"+response);
        return response;
    }


    public String signUp(SignUpDto signUpDto) {

        User user = new User();
        user.setUserName(signUpDto.getUserName());
        user.setEmail(signUpDto.getEmail());
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        userRepository.save(user);

        return "User registered successfully!";
    }
}

