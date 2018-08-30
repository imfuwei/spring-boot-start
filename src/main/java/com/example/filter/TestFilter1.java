package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class TestFilter1 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter1:经过过滤器，你的请求正常，不必过滤……");
		System.err.println(
				"servlet3+ 配置过滤器方式一，利用@WebFilter和主入口函数@ServletComponentScan(basePackages= {\"com.example.servlet\",\"com.example.filter\"})注解");
		System.err.println("以此种方式配置，filter的执行顺序是以filter类名的顺序作为执行顺序");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
