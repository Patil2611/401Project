package com.blogapp.blogapp.utils;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.blogapp.blogapp.exceptions.InvalidTokenException;

import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHelper {

    private static final String SECRET = "my-super-secret-key-should-be-very-long-and-secure";

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    //  private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Secure random 256-bit key

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
        } catch (Exception e) {
            throw new InvalidTokenException("Invalid token");
        }
    }

    public boolean validateToken(String token) {
        try {
            System.out.println("Token checking");
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new InvalidTokenException("Invalid token");
            // return false;
        }
    }
}

