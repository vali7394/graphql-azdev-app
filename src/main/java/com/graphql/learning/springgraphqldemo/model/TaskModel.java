package com.graphql.learning.springgraphqldemo.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */

public record TaskModel(long id, String content, List<String> tags, int approachCount, String createdAt) {
}
