package com.trilhabackendjr.project.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.trilhabackendjr.project.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secretKey}")
    private String secretKey;

    public String createToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withIssuer("auth-project")
                    .withSubject(user.getUsername())
                    .withExpiresAt(createExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException creationException){
            throw new RuntimeException("Error generating token", creationException);
        }
    }

    public String validToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("auth-project")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException verificationException){
            return "";
        }
    }

    private Instant createExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
