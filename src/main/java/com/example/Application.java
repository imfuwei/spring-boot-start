package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
//扫描mybatis的mapping，相当于在每个Dao中加@Mapper注解
@MapperScan("com.example.dao")
//开启事务回滚
@Transactional
//在springboot中用servlet,并以注解的方式配置servlet,需加入servlet包注解扫描
@ServletComponentScan(basePackages= {"com.example.servlet","com.example.filter"})
public class Application extends SpringBootServletInitializer{
	//如果打war包，需要继承SpringBootServletInitializer并实现configure(SpringApplicationBuilder builder)方法
	//打jar包时不需要
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	public static void main(String[] args){
		//加载外部配置文件方式之一
		//args=new String[]{"--spring.config.location=F:\\application.properties"};
		SpringApplication.run(Application.class, args);
	}
}
