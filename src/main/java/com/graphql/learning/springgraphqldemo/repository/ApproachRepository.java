package com.graphql.learning.springgraphqldemo.repository;

import com.graphql.learning.springgraphqldemo.dto.Approach;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */
@Repository
public interface ApproachRepository extends ReactiveCrudRepository<Approach,Integer> {
}
