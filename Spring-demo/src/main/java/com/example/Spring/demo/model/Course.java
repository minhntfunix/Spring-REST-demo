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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "This field is required")
	@NotNull(message = "This field is required")
	@Column(name = "title")
	private String title;
	
	@NotBlank(message = "This field is required")
	@NotNull(message = "This field is required")
	@Column(name = "year")
	private String year;	
	
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.PERSIST,
						CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "instructor_id")				
	private Instructor instructor;
	
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH,CascadeType.PERSIST,
							CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(name = "course_student",
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	public Course() {}

	public Course(int id, String title, String year) {		
		this.id = id;
		this.title = title;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void add(Student student) {		
		if (students == null) {
			students = new ArrayList<>();
		}
		students.add(student);		
	}	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", year=" + year + ", instructor=" + instructor + ", students="
				+ students + "]";
	}
	
	
	
	
	
	
	
}
