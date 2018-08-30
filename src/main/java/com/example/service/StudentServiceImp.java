package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IStudentDao;
import com.example.entity.Student;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private IStudentDao iStudentDao;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Override
	public Student getStudetById(int id) {
		return iStudentDao.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public void update() {
		Student student = new Student();
		student.setId(1);
		student.setName("adfds");
		iStudentDao.updateByPrimaryKeySelective(student);
		throw new RuntimeException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {

		// 设置redisTemplate的key和value序列化，在redis中方便阅读
		RedisSerializer<String> serializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

		// 为防止缓存穿透，加上双重检测锁

		List<Student> students = (List<Student>) redisTemplate.opsForValue().get("students");
		if (null == students) {
			synchronized (this) {
				students = (List<Student>) redisTemplate.opsForValue().get("students");
				if (null == students) {
					System.err.println("查的数据库");
					students = iStudentDao.selectAll();
					redisTemplate.opsForValue().set("students", students);
				} else {
					System.out.println("查的缓存");
				}
			}
		} else {
			System.out.println("查的缓存");
		}
		return students;
	}

}
