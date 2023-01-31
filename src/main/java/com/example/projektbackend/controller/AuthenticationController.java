package com.example.projektbackend.controller;


import com.example.projektbackend.DTO.authentication.AuthenticationRequest;
import com.example.projektbackend.config.security.MyUserDetails;
import com.example.projektbackend.config.security.MyUserDetailsService;
import com.example.projektbackend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("bad credentials");
        }
        MyUserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        var jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }

}
