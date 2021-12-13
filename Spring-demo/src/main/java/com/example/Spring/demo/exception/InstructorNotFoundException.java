package com.example.Spring.demo.exception;

public class InstructorNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstructorNotFoundException(int id) {
		super("Instructor with ID: "+ id + " not found");
	}
}
