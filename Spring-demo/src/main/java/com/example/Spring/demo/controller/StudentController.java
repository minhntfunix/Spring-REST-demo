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

import com.example.Spring.demo.exception.StudentNotFoundException;
import com.example.Spring.demo.model.Course;
import com.example.Spring.demo.model.Instructor;
import com.example.Spring.demo.model.Student;
import com.example.Spring.demo.respository.CourseRepository;
import com.example.Spring.demo.respository.InstructorRepository;
import com.example.Spring.demo.respository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;	
	
	@GetMapping
	public List<Student> list(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/add")
	public Student add(@Valid @RequestBody Student student) {		
		return studentRepository.save(student);			
	}
	
	@GetMapping("/{id}")		
	public Student findById(@PathVariable int id) {
		Optional<Student> res = studentRepository.findById(id);
		
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new StudentNotFoundException(id);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		Optional<Student> res = studentRepository.findById(id);
		
		if (res.isPresent()) {
			studentRepository.delete(res.get());
		} else {
			throw new StudentNotFoundException(id);
		}
	}	
	
}
