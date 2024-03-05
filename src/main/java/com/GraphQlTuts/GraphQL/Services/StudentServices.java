package com.GraphQlTuts.GraphQL.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;

import com.GraphQlTuts.GraphQL.Entities.Address.Address;
import com.GraphQlTuts.GraphQL.Entities.Student.Student;
import com.GraphQlTuts.GraphQL.Repositories.AddressRepository;
import com.GraphQlTuts.GraphQL.Repositories.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	public Optional<Student> getStudent(Integer id) {
		Optional<Student> checkStudent = studentRepo.findById(id);
		return checkStudent;
	}
	
	public Student addStudent(Student s) {
		Student savedStudent =studentRepo.save(s);
		return savedStudent;
	}
	
	
	public List<Address> getAddress(Student student) {
		List<Address> address = addressRepo.findByStudentId(student.getId());
		return address;
	}
	
	public Address addAddress(Address a) {
		Address savedAddress =addressRepo.save(a);
		return savedAddress;
	}
	
}
