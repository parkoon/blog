package com.hhwaaaaa1.blog.configurer.security.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtDecoder {
	private static final Logger logger = LoggerFactory.getLogger(JwtDecoder.class);

	public DecodedJWT decodeJwt(String token){
		return this.isValidToken(token).orElseThrow(()->new RuntimeException("is invalidToken.."));
	}

	private Optional<DecodedJWT> isValidToken(String token){
		DecodedJWT decodedJWT = null;

		try{
			Algorithm algorithm = Algorithm.HMAC256(com.hhwaaaaa1.blog.support.enumeration.JWT.PRIVATE_KEY.value());
			JWTVerifier jwtVerifier = JWT.require(algorithm).build();
			decodedJWT = jwtVerifier.verify(token);
		}catch(Exception e){
			logger.error(e.getMessage());
		}

		return Optional.ofNullable(decodedJWT);
	}
}
