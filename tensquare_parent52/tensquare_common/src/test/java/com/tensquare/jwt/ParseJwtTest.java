package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1ODc1NjA3NDR9.DCWk2FKSlbzafeNg2mQU91QDy-0ux0uX8Q7wwQcFqEE")
                .getBody();
        System.out.println("用户id" + claims.getId());
        System.out.println("用户名" + claims.getSubject());
        System.out.println("登陆时间" +  new SimpleDateFormat("yyyy-MM-dd").format(claims.getIssuedAt()));
    }
}
