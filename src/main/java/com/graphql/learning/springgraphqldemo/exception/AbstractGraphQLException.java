package com.graphql.learning.springgraphqldemo.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**a
 * @Author: Meeravali Shaik
 * Date: 7/27/22
 */
public class AbstractGraphQLException extends RuntimeException implements GraphQLError {

    private Map<String, Object> parameters = new HashMap();

    public AbstractGraphQLException(String message) {
        super(message);
    }

    public AbstractGraphQLException(String message,Map<String, Object> parameters) {
        this(message);
        this.parameters = parameters;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }


    @Override
    public Map<String, Object> getExtensions() {
        return this.parameters;
    }
}
