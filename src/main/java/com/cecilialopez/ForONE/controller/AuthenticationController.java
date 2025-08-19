package com.cecilialopez.ForONE.controller;

import com.cecilialopez.ForONE.domain.user.DataAuthenticationUser;
import com.cecilialopez.ForONE.domain.user.User;
import com.cecilialopez.ForONE.infra.security.DataJWTToken;
import com.cecilialopez.ForONE.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid DataAuthenticationUser dataAuthenticationUser) {
        // Imprimir los datos recibidos para depuración
        System.out.println("AuthenticationController: Login recibido: " + dataAuthenticationUser.login());
        System.out.println("AuthenticationController: Password recibido: " + dataAuthenticationUser.password());

        Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuthenticationUser.login(),
                dataAuthenticationUser.password());
        var userAuthenticated = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTtoken));
    }
}