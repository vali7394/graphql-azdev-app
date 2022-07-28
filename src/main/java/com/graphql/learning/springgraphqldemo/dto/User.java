package com.graphql.learning.springgraphqldemo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author: Meeravali Shaik
 * Date: 7/21/22
 */

@Table(name = "users")
public class User {

    @Id
    private int id;
    @Column(value = "username")
    private  String userName;
    @Column(value = "first_name")
    private String firstName;
    @Column(value = "last_name")
    private String lastName;
    @Column(value = "hashed_password")
    private String encodedPwd;
    @Column(value = "created_at")
    private String createdAt;

}
