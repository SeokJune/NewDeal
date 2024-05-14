package com.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// URI는 Vue의 서버 
		registry.addMapping("/**").allowedOrigins("http://localhost:8081").allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}