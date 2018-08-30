package com.example.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.StudentService;

@RestController
public class MybatisController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/boot/students")
	public Object students() {
		ExecutorService executorService = Executors.newFixedThreadPool(15);
		//测试缓存穿透，如果第一个查了数据库，其它的查缓存，证明缓存没有穿透
		for (int i = 0; i < 10000; i++) {
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					studentService.getStudents();
				}
			});
		}
		return studentService.getStudents();
	}

	@GetMapping("/boot/update")
	public Object update() {
		studentService.update();
		return "";
	}
}
