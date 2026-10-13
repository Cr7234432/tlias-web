package com.hairain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:testJWT
 * Package: com.hairain
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 19:43
 * @Version 1.0
 */
public class testJWT {

    @Test
    public void testGJWT(){
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        String jwt = Jwts.builder().
                signWith(SignatureAlgorithm.HS256,"aGFpcmFpbg==").
                addClaims(dataMap).
                setExpiration(new Date(System.currentTimeMillis()+3600*1000)).
                compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzkxNjM2NzMxfQ.J-qEc9MNwdyWZPYzrEyidAHM1kAQOfaO0Ot30BDolnE";
        Claims c = Jwts.parser().setSigningKey("aGFpcmFpbg==").parseClaimsJws(token).getBody();
        System.out.println(c);
    }

}
