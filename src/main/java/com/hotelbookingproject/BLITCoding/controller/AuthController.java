package com.hotelbookingproject.BLITCoding.controller;

import com.hotelbookingproject.BLITCoding.exception.UserAlreadyExistsException;
import com.hotelbookingproject.BLITCoding.model.User;
import com.hotelbookingproject.BLITCoding.request.LoginRequest;
import com.hotelbookingproject.BLITCoding.response.JwtResponse;
import com.hotelbookingproject.BLITCoding.security.jwt.JwtUtils;
import com.hotelbookingproject.BLITCoding.security.user.HotelUserDetails;
import com.hotelbookingproject.BLITCoding.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    //private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("registered");
        }catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody
                                              LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),
                        request.getPassword()) );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.getJwtTokenForUser(authentication);
        HotelUserDetails hotelUserDetails = (HotelUserDetails) authentication
                .getPrincipal();
        List<String> roles = hotelUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(new JwtResponse(
                hotelUserDetails.getId(),
                hotelUserDetails.getEmail(),
                jwt,
                roles));

    }

}
