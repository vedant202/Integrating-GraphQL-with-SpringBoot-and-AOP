package com.GraphQlTuts.GraphQL.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.GraphQlTuts.GraphQL.Entities.Address.Address;
import com.GraphQlTuts.GraphQL.Entities.Book.Book;
import com.GraphQlTuts.GraphQL.Entities.Student.Student;
import com.GraphQlTuts.GraphQL.Repositories.BookRepository;
import com.GraphQlTuts.GraphQL.Services.BookServices;
import com.GraphQlTuts.GraphQL.Services.BookSevicesImpl;
import com.GraphQlTuts.GraphQL.Services.StudentServices;


@Controller
public class GraphqlController {
	
	
	@Autowired
	StudentServices studServ;
	
	@Autowired
	BookSevicesImpl bookServ;
	
	@Autowired
	BookRepository bookRepo;
	
	@QueryMapping(name="student")
	public Student getStudent(@Argument(name="id") Integer id){
		System.out.println("Student integer id "+id);
		
		Student s = studServ.getStudent(id).get();
		return s;
		
	}
	
	@QueryMapping(name="bookTitle")
	public String getBookTitle(@Argument(name="id") String id) {
		System.out.println("book title "+id);
        // Your logic to fetch the title for a book
        return bookRepo.findById(id).get().getName();
    }
	
	@SchemaMapping(value ="address")
	public List<Address> getAddress(Student student){
		List<Address> address = studServ.getAddress(student);
		return address;
		
	}
	
	@SchemaMapping(value = "phone")
    public String getPhone(Student s) {
        System.out.println("Fetching phone");
        throw new RuntimeException("Did not find phone data");
    }
	
	@QueryMapping(name="getBook")
	public Book getBook(@Argument(name="id") String id) {
		Book b = bookServ.getBook(id);
		return b;
	}
	
	
	@QueryMapping(name="getAllBooks")
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	
	@MutationMapping(name="createBook")
	public Book createBook(@Argument(name="book") Book book) {
		return bookRepo.save(book);
	}
	
	
	@MutationMapping(name="createStudent")
	public Student createStudent(@Argument(name="student") Student student) {
		Student createdStudent = studServ.addStudent(student);
		return createdStudent;
	}
	
	@MutationMapping(name="createAddress")
	public Address createAddress(@Argument(name="address") Address a) {
		Address createdAddress = studServ.addAddress(a);
		return createdAddress;
	}
	
}
