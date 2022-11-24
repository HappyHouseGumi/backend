package com.jsg.house.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:oauth.properties")
public class OauthConfig {

	@Value("${oauth.naver.client-id}")
	private String clientId;
	
	@Value("${oauth.naver.secret-key}")
	private String secretKey;

}
