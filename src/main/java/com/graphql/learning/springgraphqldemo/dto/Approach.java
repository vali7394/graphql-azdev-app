package com.graphql.learning.springgraphqldemo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */

@Table(name = "approaches")
public class Approach {
    @Id
    private int id;
    @Column(value = "content")
    private String content;
    @Column(value = "task_id")
    private int taskId;
    @Column(value = "user_id")
    private int userId;
    @Column(value = "vote_count")
    private int voteCount;
    @Column(value = "created_at")
    private String createdAt;

}
