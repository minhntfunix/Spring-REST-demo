package com.example.Spring.demo.exception;

public class CourseNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(int id) {
		super("Course with ID: "+ id + " not found");
	}
}
