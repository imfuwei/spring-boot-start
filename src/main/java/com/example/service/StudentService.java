package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {
	public Student getStudetById(int id);

	public void update();

	public List<Student> getStudents();
}
