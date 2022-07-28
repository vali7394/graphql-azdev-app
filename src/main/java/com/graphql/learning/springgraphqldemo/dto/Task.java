package com.graphql.learning.springgraphqldemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */


@Table(name = "tasks", schema = "azdev")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Task {

    @Id
    private long id;

    @Column(value =  "content")
    private String content;
    @Column(value =  "tags")
    private String tags;
    @Column(value =  "user_id")
    private String userId;
    @Column(value =  "is_private")
    private boolean isPrivate;
    @Column(value = "approach_count")
    private int approachCount;
    @Column(value = "created_At")
    private Timestamp createdAt;
}
