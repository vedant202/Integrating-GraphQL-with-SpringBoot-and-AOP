package com.GraphQlTuts.GraphQL.Services;

import com.GraphQlTuts.GraphQL.Entities.Book.Book;

public interface BookServices {
	Book getBook(String id);
}
