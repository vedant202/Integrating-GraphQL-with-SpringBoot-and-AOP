package com.GraphQlTuts.GraphQL.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GraphQlTuts.GraphQL.Entities.Student.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
