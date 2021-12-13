package com.example.Spring.demo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table (name = "student")
public class Student {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "This field is required")
	@Size(max = 15, message = "Length must be less than or equal to 15")
	@Column(name = "first_name")
	private String firstName;	
	
	@NotBlank(message = "This field is required")
	@Size(max = 15, message = "Length must be less than or equal to 15")
	@Column(name = "last_name")
	private String lastName;	
	
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade = { CascadeType.DETACH, CascadeType.PERSIST, 
							CascadeType.REFRESH,CascadeType.MERGE })
	@JoinTable(name = "course_student", 
				joinColumns = @JoinColumn(name = "student_id"), 
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	public Student() {}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	public void add(Course course) {
		if (course == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", courses=" + courses
				+ "]";
	}
	
	
	

	
	
	
	
	
	
	
	
}
	