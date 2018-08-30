package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Interceptor.LoginInterceptor;
/**
 * webMvc配置
 * @author zhang
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//登录拦截器
		InterceptorRegistration loginInterceptor = registry.addInterceptor(new LoginInterceptor());
		//需要拦截的url
		String[] patterns = {"/boot/**"};
		//不需要拦截的url
		String[] excludePathPatterns= {"/boot/hello1"};
		loginInterceptor.addPathPatterns(patterns);
		loginInterceptor.excludePathPatterns(excludePathPatterns);
		//……更多拦截器，如权限拦截器
	}
}
