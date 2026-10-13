package com.hairain.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:JWTUtils
 * Package: com.hairain.utils
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 20:03
 * @Version 1.0
 */
@Component
public class JWTUtils {

    private static  final String SECRET_KEY = "aGFpcmFpbg==";

    public static String productJWT(Map<String,Object> dataMap){
        return Jwts.builder().
                signWith(SignatureAlgorithm.HS256,SECRET_KEY).
                addClaims(dataMap).setExpiration(new Date(System.currentTimeMillis()+12 * 60 * 60 * 1000)).
                compact();
    }

    public static Claims parseJWT(String jwt)throws Exception{
        return Jwts.parser().
                setSigningKey(SECRET_KEY).
                parseClaimsJws(jwt).
                getBody();
    }

}
