package com.graphql.learning.springgraphqldemo;

import com.graphql.learning.springgraphqldemo.exception.AbstractGraphQLException;
import com.graphql.learning.springgraphqldemo.exception.GraphQLErrorAdaptor;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringGraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlDemoApplication.class, args);
	}

	/*@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
		return builder -> {
			builder.type("Query",
			wiring -> wiring.dataFetcher("customers", environment -> customerService.getCustomers()).
				dataFetcher("customerById", environment -> customerService.customerById(environment.getArgument("id"))));
			builder.type("Customer", wiring -> wiring.dataFetcher("profile", env->customerService.getProfile(env.getSource())));
		};
	}*/

}
