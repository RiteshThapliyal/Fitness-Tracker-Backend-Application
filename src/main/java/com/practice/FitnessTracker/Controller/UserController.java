package com.practice.FitnessTracker.Controller;

import com.practice.FitnessTracker.DTO.UserRequest;
import com.practice.FitnessTracker.DTO.UserResponse;
import com.practice.FitnessTracker.DataBags.LoginRequest;
import com.practice.FitnessTracker.DataBags.LoginResponse;
import com.practice.FitnessTracker.DataBags.User;
import com.practice.FitnessTracker.Security.JwtUtils;
import com.practice.FitnessTracker.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register (@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.register(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {

        User user = userService.authenticate(loginRequest);

        String token = jwtUtils.generateToken(user.getId(), user.getRole().name());

        return ResponseEntity.ok(new LoginResponse(
                token, userService.mapToResponse(user)
        ));
    }
}