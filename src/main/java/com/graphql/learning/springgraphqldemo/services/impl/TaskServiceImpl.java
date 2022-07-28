package com.graphql.learning.springgraphqldemo.services.impl;

import com.graphql.learning.springgraphqldemo.dto.Task;
import com.graphql.learning.springgraphqldemo.exception.TasksNotFoundException;
import com.graphql.learning.springgraphqldemo.model.TaskModel;
import com.graphql.learning.springgraphqldemo.repository.TaskRepository;
import com.graphql.learning.springgraphqldemo.services.TaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */
@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Flux<TaskModel> fetchAllTaskList() {
        return taskRepository.findTaskBy()
                .map(task -> new TaskModel(task.getId(),task.getContent(),
                        List.of(task.getTags().split(",")),
                        task.getApproachCount(),
                        task.getCreatedAt().toString())).onErrorResume(error->Flux.error(new TasksNotFoundException("Task is not found")));
    };
}
