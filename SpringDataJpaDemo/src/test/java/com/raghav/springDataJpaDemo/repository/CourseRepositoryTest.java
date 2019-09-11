package com.raghav.springDataJpaDemo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.raghav.springDataJpaDemo.SpringDataJpaDemoApplication;
import com.raghav.springDataJpaDemo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringDataJpaDemoApplication.class)
public class CourseRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void contextLoads(){
		logger.info("Test is running!!!");
	}
	
	@Test
	public void findById_basic(){
		Course course = courseRepository.findById(10001l);
		assertEquals("jpa in 50 steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic(){
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic(){
		// Get a course from database
		Course course = courseRepository.findById(10001L);
		assertEquals("jpa in 50 steps", course.getName());
		
		// updating the course
		course.setName("Jpa in 50 steps updated!!!");
		courseRepository.save(course);
		
		//asserting the updated values
		Course course1 = courseRepository.findById(10001L);
		assertEquals("Jpa in 50 steps updated!!!", course1.getName());
	}
	
	
	
}
