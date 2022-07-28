package com.graphql.learning.springgraphqldemo.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import graphql.execution.SimpleDataFetcherExceptionHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: Meeravali Shaik
 * Date: 7/28/22
 */
@Component
public class CustomGraphQLErrorHandler extends SimpleDataFetcherExceptionHandler {

    @Override
    public DataFetcherExceptionHandlerResult onException(
            DataFetcherExceptionHandlerParameters handlerParameters) {
        ExceptionWhileDataFetching error =
                new ExceptionWhileDataFetching(
                        handlerParameters.getPath(),
                        handlerParameters.getException(),
                        handlerParameters.getSourceLocation());
        return DataFetcherExceptionHandlerResult.newResult().error(error).build();
    }

}
