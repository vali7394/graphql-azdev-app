package com.graphql.learning.springgraphqldemo.exception;

/**
 * @Author: Meeravali Shaik
 * Date: 7/27/22
 */
public class TasksNotFoundException extends AbstractGraphQLException {
    public TasksNotFoundException(String message){
        super(message);
    }
}
