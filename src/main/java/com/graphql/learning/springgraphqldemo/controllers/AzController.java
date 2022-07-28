package com.graphql.learning.springgraphqldemo.controllers;

import com.graphql.learning.springgraphqldemo.model.TaskModel;
import com.graphql.learning.springgraphqldemo.services.TaskService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Meeravali Shaik
 * Date: 7/18/22
 */
@RestController
public class AzController {
    Format f = new SimpleDateFormat("HH.mm.ss");

    TaskService taskService;

    public AzController(TaskService taskService) {
        this.taskService = taskService;
    }

    @QueryMapping(value = "currentTime")
    public Mono<String> getServerCurrentTime(){
        return Mono.just(f.format(new Date()));
    }

    @SchemaMapping(typeName = "Query" ,value = "taskMainList")
    public Flux<?> fetchAllTasks(){
        return taskService.fetchAllTaskList();
    }
}
