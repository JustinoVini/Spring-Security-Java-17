package br.com.vinicius.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.crud.domain.models.User;
import br.com.vinicius.crud.domain.payload.AuthenticationDTO;
import br.com.vinicius.crud.domain.payload.RegisterDTO;
import br.com.vinicius.crud.domain.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        UserDetails existingUser = this.userRepository.findByLogin(data.login());

        if (existingUser != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.login(), encryptPassword, data.role());

            this.userRepository.save(newUser);

            return ResponseEntity.ok().build();
        }
    }

}
