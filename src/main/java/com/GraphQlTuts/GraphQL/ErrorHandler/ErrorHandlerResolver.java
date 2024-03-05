package com.GraphQlTuts.GraphQL.ErrorHandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ErrorHandlerResolver extends DataFetcherExceptionResolverAdapter {
	
	@Override
	protected List<GraphQLError> resolveToMultipleErrors(Throwable tx,DataFetchingEnvironment ev){
		GraphQLError error = GraphqlErrorBuilder.newError(ev)
		.message(tx.getMessage()).build();
		
		return Arrays.asList(error);
	}
}
