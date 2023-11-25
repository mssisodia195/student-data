package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1,"maths","differentiation and integration"));
//		list.add(new Course(2,"english","poetry and articles"));
//		list.add(new Course(3,"physics", "theory of relativity"));

	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for (Course item : list) {
//			if(item.getId() == courseId) {
//				c = item;
//				break;
//			}
//		}
//		return c;
		try {
		return courseDao.getOne(courseId);
		} catch(Exception e) {
			return new Course(1,"kk",e.getLocalizedMessage());
		}
	}

	@Override
	public void addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
	}

	@Override
	public void updateCourse(Course course) {
//		for (Course item : list) {
//			if(item.getId() == course.getId()) {
//				item.setTitle(course.getTitle());
//				item.setDescription(course.getDescription());
//				break;
//			}
//		}
		
		courseDao.save(course);
		
	}

	@Override
	public void deleteCourse(long courseId) {
//		for (Course item : list) {
//			if(item.getId() == courseId) {
//				list.remove(item);
//				break;
//			}
//		}
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		
	}

	



}
