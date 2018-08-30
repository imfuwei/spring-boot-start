package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

	@RequestMapping("/boot/hello")
	public @ResponseBody String HelloBoot() {
		return "Hello Spring boot";
	}
	@RequestMapping("/boot/hello1")
	public @ResponseBody String Hello1Boot() {
		return "Hello Spring boot";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("msg", "测试jsp");
		return "index";
	}
}
