package com.raghav.springDataJpaDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghav.springDataJpaDemo.entity.Course;
import com.raghav.springDataJpaDemo.repository.CourseRepository;

@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001l);
		logger.info("{}", course);
		//repository.deleteById(10001l);
		Course cs = new Course();
		cs.setName("Microservices in 100 steps");
		repository.save(cs);
	}

}
