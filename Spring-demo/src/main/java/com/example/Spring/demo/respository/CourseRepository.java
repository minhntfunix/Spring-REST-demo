package com.example.Spring.demo.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring.demo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
	
}
