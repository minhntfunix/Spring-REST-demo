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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "instructor")
public class Instructor {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "This field is required")
	@NotNull(message = "This field is required")
	@Size(max = 15, message = "Length must be less than or equal to 15")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "This field is required")
	@NotNull(message = "This field is required")
	@Size(max = 15, message = "Length must be less than or equal to 15")
	@Column(name = "last_name")
	private String lastName;
	
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", 
				message = "Incorrect email format")
	@NotBlank(message = "This field is required")
	@NotNull(message = "This field is required")
	@Column(name = "email")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	private List<Course>courses;
	
	public Instructor() {}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName= firstName;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void add(Course course) {
		if (course == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
		course.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", courses=" + courses + "]";
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
	