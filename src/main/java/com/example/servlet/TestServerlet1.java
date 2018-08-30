package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用servlet3+,路径以注解方式配置，需要在application.java中上开启包扫描@ServletComponentScan(basePackages= {"com.example.servlet"})

@WebServlet(urlPatterns= {"/testServlet1"})
public class TestServerlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print("使用servlet3+,路径以注解方式配置，需要在application.java中上开启包扫描@ServletComponentScan(basePackages= {\"com.example.servlet\"})");
	}

}
