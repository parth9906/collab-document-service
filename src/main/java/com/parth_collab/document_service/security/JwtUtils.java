package com.parth_collab.document_service.security;


import com.parth_collab.document_service.dto.UserInfo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Map;
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public boolean validateJwt(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public Map<String, Object> extractClaims(String token) {
        return parseClaims(token).getBody();
    }

    public UserInfo extractUser(String token) {
        Map<String, Object> claims = extractClaims(token);
        UserInfo user = new UserInfo();

        user.setUsername((String) claims.get("username"));
        user.setEmail((String) claims.get("email"));
        user.setRole((String) claims.get("role"));
        user.setFirstName((String) claims.get("firstName"));
        user.setLastName((String) claims.get("lastName"));
        user.setId((String) claims.get("id"));

        return user;
    }

    private Jws<Claims> parseClaims(String token) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}

