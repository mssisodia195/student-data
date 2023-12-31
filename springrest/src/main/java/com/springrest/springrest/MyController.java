package com.springrest.springrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//get particular course
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//add course
	
	@PostMapping(path = "/courses", consumes = "application/json")
	public String addCourse(@RequestBody Course course) {
		this.courseService.addCourse(course);
		return "The Course has been added";
	}
	
	//update course
	@PutMapping("/courses")
	public String updateCourse(@RequestBody Course course) {
		this.courseService.updateCourse(course);
		return "The course has been updated";
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return "The course has been deleted";
	}
	
	
	

}
