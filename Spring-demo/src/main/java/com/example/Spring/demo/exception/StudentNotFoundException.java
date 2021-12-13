package com.example.Spring.demo.exception;

public class StudentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(int id) {
		super("Student with ID: "+ id + " not found");
	}
}
