package com.example.apidemo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenUtils {
    private final static String ACCES_TOKEN_SECRET ="firmaSecretaEncriptada";
    /*Tiempo de validez del token */
    private final static long ACCES_TOKEN_VALIDATY_SECONDS = 2_592_000L;

    public static String crearToken(String nombre, String email){

        /*Pasamos los segundos a milisegundos*/
        long expirationTime = ACCES_TOKEN_VALIDATY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        /* Informacion extra que viaja con el token*/
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        /* Retornamos el token creado con el mail, la fecha de expiracion, la informacion extra
        * y la firma*/
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)

                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();

    }

    /*El cliente envia el token  y lo parseamos para que spring security autentifique*/
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
       try {
           Claims claims = Jwts.parserBuilder()
                   .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
           String email = claims.getSubject();

           return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
       } catch (JwtException e){
           return null;
       }
    }
}
