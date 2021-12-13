package com.example.Spring.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.demo.exception.CourseNotFoundException;
import com.example.Spring.demo.exception.InstructorNotFoundException;
import com.example.Spring.demo.model.Course;
import com.example.Spring.demo.model.Instructor;
import com.example.Spring.demo.model.Student;
import com.example.Spring.demo.respository.CourseRepository;
import com.example.Spring.demo.respository.InstructorRepository;
import com.example.Spring.demo.respository.StudentRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Course> list(){
		return courseRepository.findAll();
	}
	
	@PostMapping("/add")
	public Course add(@Valid @RequestBody Course course) {
		Course tempcourse = new Course();
		
		tempcourse.setTitle(course.getTitle());
		tempcourse.setYear(course.getYear());
		courseRepository.save(tempcourse);
		return tempcourse;
	}
	
	@GetMapping("/{id}")		
	public Course findById(@PathVariable int id) {
		Optional<Course> res = courseRepository.findById(id);
		
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new CourseNotFoundException(id);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		Optional<Course> res = courseRepository.findById(id);
		
		if (res.isPresent()) {
			courseRepository.delete(res.get());
		} else {
			throw new InstructorNotFoundException(id);
		} 
	}
	
	@PutMapping("/{courseId}/instructor/{instructorID}")
	public Course addInstructor(@PathVariable int courseId,@PathVariable int instructorID) {
		Optional<Course> res = courseRepository.findById(courseId);
		Optional<Instructor> res1 = instructorRepository.findById(instructorID);
		
		if (!res.isPresent()) {
			throw new CourseNotFoundException(courseId);
		} else if (!res1.isPresent()) {
			throw new InstructorNotFoundException(instructorID);
		}

		Instructor tempInstructor = res1.get();
		Course tempCourse = res.get();
		
		tempCourse.setInstructor(tempInstructor);
		return courseRepository.save(tempCourse);	
	}
	
	@PutMapping("/{courseId}/student/{studentID}")
	public Course addStudent(@PathVariable int courseId, @PathVariable int studentID) {
		Optional<Course> res = courseRepository.findById(courseId);
		Optional<Student> res1 = studentRepository.findById(studentID);
		
		if (!res.isPresent()) {
			throw new CourseNotFoundException(courseId);
		} else if (!res1.isPresent()) {
			throw new InstructorNotFoundException(studentID);
		}		
		
		Student student = studentRepository.findById(studentID).get();
		Course tempCourse = courseRepository.findById(courseId).get();
		
		tempCourse.add(student);
		return courseRepository.save(tempCourse);		
	}	
	
}
