package com.graphql.learning.springgraphqldemo.exception;

import graphql.ErrorClassification;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

/**
 * @Author: Meeravali Shaik
 * Date: 7/28/22
 */
public class GraphQLErrorAdaptor implements GraphQLError {

    private final GraphQLError graphQLError;

    public GraphQLErrorAdaptor(GraphQLError graphQLError) {
        this.graphQLError = graphQLError;
    }

    @Override
    public String getMessage() {
        return (graphQLError instanceof ExceptionWhileDataFetching)
                ? ((ExceptionWhileDataFetching) graphQLError).getException().getMessage()
                : graphQLError.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return graphQLError.getLocations();
    }

    @Override
    public ErrorClassification getErrorType() {
        return graphQLError.getErrorType();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return graphQLError.getExtensions();
    }
}
