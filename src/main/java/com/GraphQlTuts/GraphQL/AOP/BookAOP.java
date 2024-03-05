package com.GraphQlTuts.GraphQL.AOP;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.GraphQlTuts.GraphQL.Entities.Book.Book;

import jakarta.persistence.criteria.Join;


@Aspect
@Component
public class BookAOP {
	Logger log = LogManager.getLogger(this.getClass());

	@Before("execution(* com.GraphQlTuts.GraphQL.Controller.GraphqlController.getAllBooks())")
	public void beforeFetchingBooks(JoinPoint jointPoint) {
		log.info("Getting all the Books");
		System.out.println("Getting all books");
		System.out.println("Getting args :- "+jointPoint.getSignature().getName());
	}
	
	@Before("execution(* com.GraphQlTuts.GraphQL.Services.BookSevicesImpl.getBook(..))")
	public void beforFetchingBook(JoinPoint jointPoint) {
		log.info("Get Book");
		System.out.println("Get Book with id");
		Integer id=0;
		for(Object arg:jointPoint.getArgs()) {
			id = Integer.valueOf(arg.toString());
			System.out.println("Arg :- "+id);
		}
		
		if(id>1) {
			throw new RuntimeException("id 2 not present");
		}
		
	}
	
	@AfterReturning(pointcut = "execution(* com.GraphQlTuts.GraphQL.Services.BookSevicesImpl.getBook(..))",returning = "result")
	public void afterFetchingBook(JoinPoint joinPoint,Object result) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] method = result.getClass().getDeclaredMethods();
		for(var i: method) {
			if(i.getName().equalsIgnoreCase("getName")) {
				 Object o= i.invoke(result);
				 System.out.println("Invoked Method getName "+ o);
			}
			
		}
        System.out.println("Method " + joinPoint.getSignature().getName() + " returned: " + result);
        
       
        
	}
	
}
