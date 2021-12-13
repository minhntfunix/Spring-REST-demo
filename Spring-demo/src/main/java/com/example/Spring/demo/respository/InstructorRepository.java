package com.example.Spring.demo.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring.demo.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
	
}
