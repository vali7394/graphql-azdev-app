package com.graphql.learning.springgraphqldemo.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Meeravali Shaik
 * Date: 7/28/22
 */
@Component
public class GraphQLErrorHandlerImpl implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> clientErrors = errors.stream()
                .filter(this::isClientError)
                .collect(Collectors.toList());

        List<GraphQLError> serverErrors = errors.stream()
                .filter(e -> !isInternalError(e))
                .map(GraphQLErrorAdaptor::new)
                .collect(Collectors.toList());

        List<GraphQLError> e = new ArrayList<>();
        e.addAll(clientErrors);
        e.addAll(serverErrors);
        return e;
    }

    private boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }
    protected boolean isInternalError(GraphQLError error) {
        return (error instanceof ExceptionWhileDataFetching) &&
                (((ExceptionWhileDataFetching) error).getException() instanceof AbstractGraphQLException);
    }
}
