package org.example.onlineshop.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.onlineshop.entity.TokenPayLoad;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "thisIsASecretKeyForJWT32Char32132131231213213gdgdgdfdfgdf";
    // Đảm bảo >= 32 ký tự
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // Chuyển String thành Key hợp lệ

    public String generateToken(TokenPayLoad tokenPayLoad, long expiredTime) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("payload", tokenPayLoad);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(KEY, SignatureAlgorithm.HS256) // Dùng Key hợp lệ
                .compact();
    }

    public TokenPayLoad getTokenPayload(String token) {
        return getClaimsfromTOken(token, (Claims claim) -> {
            Map<String, Object> MapResult = (Map<String, Object>) claim.get("payload");
            return TokenPayLoad.builder()
                    .accountId((Integer) MapResult.get("accountId"))
                    .username((String) MapResult.get("username"))
                    .build();
        });
    }

    public <T> T getClaimsfromTOken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY) // Dùng Key hợp lệ
                .build()
                .parseClaimsJws(token) // Giải mã JWT
                .getBody(); // Lấy payload (claims)

        return claimsResolver.apply(claims);
    }




    public boolean isValid(String token, TokenPayLoad tokenPayLoad) {
        if (isTokenExpired(token)) {
            return false;

        }
        TokenPayLoad tokenPayLoad1 = getTokenPayload(token);
        return tokenPayLoad1.getAccountId() == tokenPayLoad.getAccountId();
    } // check co hop le khong

    private boolean isTokenExpired(String token) {
        Date expriedTime = getClaimsfromTOken(token, Claims::getExpiration);
        return expriedTime.before(new Date());
    } // check hạn sử dụng
}

