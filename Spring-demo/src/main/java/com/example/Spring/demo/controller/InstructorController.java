package com.example.Spring.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.demo.exception.InstructorNotFoundException;
import com.example.Spring.demo.model.Instructor;
import com.example.Spring.demo.respository.InstructorRepository;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@GetMapping
	public List<Instructor> findAll(){
		return instructorRepository.findAll();
	}
	
	@PostMapping("/add")
	public Instructor add(@Valid @RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	@GetMapping("/{id}")		
	public Instructor findById(@PathVariable int id) {
		Optional<Instructor> res = instructorRepository.findById(id);
		
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new InstructorNotFoundException(id);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		Optional<Instructor> res = instructorRepository.findById(id);
		
		if (res.isPresent()) {
			instructorRepository.delete(res.get());
		} else {
			throw new InstructorNotFoundException(id);
		}
	}
	
	
}
