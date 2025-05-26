package pe.edu.utp.isi.dwi.sodi.sodi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    // necesita la clase secreta
    @Value("${jwt.secret}") // anotacion que conecta con la configuracion.properties
    private String secretKey;

    // necesita el tiempo de expiracion
    @Value("${jwt.expiration}") // anotacion que conecta con la configuracion.properties
    private long expirationTime;

    // obtener clave secreta
    private Key getSigningKey() {
        // retorna clave secreta debidamente codificada
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // con lo anterior, permitira generar , sobre un nombre de usuario
    // entonces el usuario envia su nombre de usuario y contraseña, el servidor lo valido y se genera token
    public String generateToken(String correo, List<String> roles) {
        // retorna, va a construir / generar el token (con su estructura: header, peyload, signature)
        return Jwts.builder()
                .setSubject(correo) // el dato principal que es el usarname
                .claim("roles", roles)
                .setIssuedAt(new Date()) // fecha en que se genera
                //  la fecha actual + el perdiodo de expiracion
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // mecanismo de firma
                .compact(); //  compacta todo
    }

    // permite extraer el nombre de usuario que esta embeido o acoplado en el PAYLOAD del token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> extractRoles(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("roles", List.class);
    }

    // verifica si el token es válido
    public boolean isTokenValid(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // verifica si el token ha expirado
    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
