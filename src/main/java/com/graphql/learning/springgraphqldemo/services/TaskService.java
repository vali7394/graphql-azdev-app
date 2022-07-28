package com.graphql.learning.springgraphqldemo.services;

import com.graphql.learning.springgraphqldemo.dto.Task;
import com.graphql.learning.springgraphqldemo.model.TaskModel;
import reactor.core.publisher.Flux;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */

public interface TaskService {
    Flux<?> fetchAllTaskList();
}
