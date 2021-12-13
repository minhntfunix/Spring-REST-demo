package com.example.Spring.demo.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
}
