package com.trilhabackendjr.project.controllers;


import com.trilhabackendjr.project.controllers.dto.AuthResponseDto;
import com.trilhabackendjr.project.controllers.dto.AuthenticationDto;
import com.trilhabackendjr.project.controllers.dto.RegisterDto;
import com.trilhabackendjr.project.entities.User;
import com.trilhabackendjr.project.repository.UserRepository;
import com.trilhabackendjr.project.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data) {
        var usernameAndPassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = this.authenticationManager.authenticate(usernameAndPassword);

        var token = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data){
        if(this.userRepository.findByUsername(data.username()) != null)
            return ResponseEntity.badRequest().build();

        String hashpassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), hashpassword);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
