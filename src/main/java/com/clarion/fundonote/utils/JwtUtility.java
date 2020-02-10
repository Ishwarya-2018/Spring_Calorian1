package com.clarion.fundonote.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtility {
	private JwtUtility() {
	}

	private static final String secretKey = "secret123";

	public static String generateToken(Long userid) {
		try {
			String token = JWT.create().withClaim("userId", userid)
//					.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.sign(Algorithm.HMAC512(secretKey));
			return token;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Long validateToken(String token) {
		if (token != null) {
			// parse the token.
			return JWT.require(Algorithm.HMAC512(secretKey)).build().verify(token).getClaim("userId").asLong();
		}
		return null;
	}
}
