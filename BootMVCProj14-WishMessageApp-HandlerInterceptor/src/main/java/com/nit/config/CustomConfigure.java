package com.nit.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nit.interceptor.TimeoutCheckInterceptor;

@Component
public class CustomConfigure implements WebMvcConfigurer {
	public CustomConfigure() {
		System.out.println("CustomConfigure::0-para construcotr");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomConfigure.addInterCeptors()");
		registry.addInterceptor(new TimeoutCheckInterceptor());
	}

}
