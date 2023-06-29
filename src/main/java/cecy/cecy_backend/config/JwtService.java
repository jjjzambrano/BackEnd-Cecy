package cecy.cecy_backend.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String  SECRET_KEY = "qgU3lJ5lNCROReJrLtMOwvqpazRYYmWomYR0I8faefa5sWuMOm7ACH/yDCYbouLn";

    public String extractUserCedula(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // extract single Claim

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAlClaims(token);
        return claimResolver.apply(claims);

    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    
    public String generateToken(Map<String, Object>  extractClaims, UserDetails userDetails){
        return Jwts.builder()
        .setClaims(extractClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 24))
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userCedula = extractUserCedula(token);
        return (userCedula.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAlClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    
    private Key getSignInKey(){
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); 
    return  Keys.hmacShaKeyFor(keyBytes);
    }


}
