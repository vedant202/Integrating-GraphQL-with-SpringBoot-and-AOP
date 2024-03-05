package com.GraphQlTuts.GraphQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;

import com.GraphQlTuts.GraphQL.Entities.Book.Book;
import com.GraphQlTuts.GraphQL.Repositories.BookRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GraphQlApplication {
	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}
	
	@EventListener(value = ApplicationReadyEvent.class)
	public void addBook() {
		bookRepository.saveAll(List.of(new Book("1","Lost World")));
	}

}
