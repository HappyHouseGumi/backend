package com.jsg.house.user.model.service;

public interface JwtService {
	String createToken(int userId);
	boolean checkToken(String userToken);
}
