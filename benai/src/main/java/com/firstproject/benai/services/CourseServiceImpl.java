package com.firstproject.benai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstproject.benai.dao.courseDao;
import com.firstproject.benai.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private courseDao coursesDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
		
		
//		list = new ArrayList<>();
//		list.add(new Course(145, "JAVA", "Beautiful course"));
//		list.add(new Course(120, "C++", "Introduction to c++"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return coursesDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c = null;
//		
//		for(Course course: list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		
		return coursesDao.getOne(courseId);
	}

	// add course 
	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
		coursesDao.save(course);
		return course;
	}

	// update
	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			if(e.getId() ==  course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
		coursesDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		
		Course entity = coursesDao.getOne(courseId);
		coursesDao.delete(entity);

//		list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
		
	}
	

}
