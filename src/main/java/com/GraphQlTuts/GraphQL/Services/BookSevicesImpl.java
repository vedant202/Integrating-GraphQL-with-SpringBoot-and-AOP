package com.GraphQlTuts.GraphQL.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GraphQlTuts.GraphQL.Entities.Book.Book;
import com.GraphQlTuts.GraphQL.Repositories.BookRepository;

@Service
public class BookSevicesImpl implements BookServices {
	
	@Autowired
	BookRepository bookRepo;
	
	@Override
	public Book getBook(String id) {
		// TODO Auto-generated method stub
		Book b=bookRepo.findById(id).orElseThrow(()->{
			String exception = "Book Not Found with book id %s Exception".formatted(id);
			return new RuntimeException(exception);
		});
		return b;
	}
}
