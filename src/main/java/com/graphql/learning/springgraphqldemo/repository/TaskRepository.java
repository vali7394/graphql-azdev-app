package com.graphql.learning.springgraphqldemo.repository;

import com.graphql.learning.springgraphqldemo.dto.Task;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */

@Repository
public interface TaskRepository extends ReactiveCrudRepository<Task,Long> {
        @Query("SELECT * FROM tasks WHERE is_private = FALSE ORDER BY created_at DESC LIMIT 100" )
        Flux<Task> findTaskBy();

}
