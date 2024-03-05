package com.GraphQlTuts.GraphQL.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.GraphQlTuts.GraphQL.Entities.Book.Book;

@GraphQlRepository
public interface BookRepository extends JpaRepository<Book, String>{
	
}
