package com.jsg.house.user.model.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService{
	private static final String SALT = "jsg";
	
	@Override
	public String createToken(int userId) {
		String jwt = Jwts.builder()
				// Header 설정 : 토큰의 타입, 해쉬 알고리즘 정보 세팅.
				.setHeaderParam("typ", "JWT")
				.setHeaderParam("regDate", System.currentTimeMillis()) // 생성 시간
				// Payload 설정 : 유효기간(Expiration), 토큰 제목 (Subject), 데이터 (Claim) 등 정보 세팅.
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 토큰 유효기간
				.setSubject("access-token") // 토큰 제목 설정 ex) access-token, refresh-token
				.claim("userId", userId) // 저장할 데이터
				// Signature 설정 : secret key를 활용한 암호화.
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact(); // 직렬화 처리.
		return jwt;
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		try {
			// charset 설정 안하면 사용자 플랫폼의 기본 인코딩 설정으로 인코딩 됨.
			key = SALT.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		return key;
	}

	@Override
	public boolean checkToken(String userToken) {
		String[] tokens = userToken.split("\\.");
		try {
			Jws<Claims> claims = Jwts.parser()
					.setSigningKey(this.generateKey())
					.parseClaimsJws(userToken);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
}
