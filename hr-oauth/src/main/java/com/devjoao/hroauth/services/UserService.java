package com.devjoao.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devjoao.hroauth.entities.User;
import com.devjoao.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	// Para teste
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();// cominiucar com o nosso serviço de usuario
		if (user == null) {
			logger.error("email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found " + email);
		return user;
	}
}
