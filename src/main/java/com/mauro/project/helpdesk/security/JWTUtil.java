package com.mauro.project.helpdesk.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    private final SecretKey secretKey;
    private final Long expiration;

    public JWTUtil(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") Long expiration) {
        // Crie uma chave segura para o algoritmo HS512 usando a classe Keys
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        this.expiration = expiration;
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }
}
