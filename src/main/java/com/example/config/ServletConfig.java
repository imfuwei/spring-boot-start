package com.example.config;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.servlet.TestServerlet2;

/**
 * springboot 配置servlet方式2，利用@Bean 注册
 * 
 * @author zhang
 *
 */
@Configuration
public class ServletConfig {
	/**
	 * @Bean 相当于spring中的<bean id="registrationBean" class=
	 *       "org.springframework.boot.web.servlet.ServletRegistrationBean"></bean>
	 *       id=方法名（）
	 *       class=返回的全限定性类名org.springframework.boot.web.servlet.ServletRegistrationBean
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<Servlet> registrationBean() {
		ServletRegistrationBean<Servlet> registServlet = new ServletRegistrationBean<Servlet>(new TestServerlet2(),
				"/testServlet2");
		return registServlet;
	}
}
