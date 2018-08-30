package com.example.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.example.filter.TestFilter2;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<Filter> registFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean=new FilterRegistrationBean<Filter>(new TestFilter2());
		//拦截路径
		filterRegistrationBean.addUrlPatterns("/*");
		//filter的执行顺序,
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
	
	/**
	 	* springboot 字符编码过渡器的方式一 由于springboot自己在application.properties配置文件中，默认已经开启了编码，如果想用这一种方式，需要在
	 	* application.properties文件中关闭默认spring.http.encoding.enabled=false，此种方式才能生效
		 * 等价于
		*web.xml中的  
		*<filter>
		*<filter-name>characterEncoding</filter-name>
		*<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		*<init-param>
		*  <param-name>forceEncoding</param-name>
		*  <param-value>true</param-value>
		*</init-param>
		*<init-param>
		*  <param-name>encoding</param-name>
		*  <param-value>utf-8</param-value>
		*</init-param>
		*</filter>
		*<filter-mapping>
		*<filter-name>characterEncoding</filter-name>
		*<url-pattern>/*</url-pattern>
		*</filter-mapping>
	  	*<filter>
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Filter> characterEncoding(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
		characterEncodingFilter.setForceEncoding(true);
		characterEncodingFilter.setEncoding("UTF-8");
		filterRegistrationBean.setFilter(characterEncodingFilter);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
