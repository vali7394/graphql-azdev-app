package com.graphql.learning.springgraphqldemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import reactor.test.StepVerifier;

import java.util.ArrayList;

/**
 * @Author: Meeravali Shaik
 * Date: 7/26/22
 */
@DataR2dbcTest()
@Testcontainers
/*@TestPropertySource(properties = {
        "spring.r=r2dbc:tc:postgresql:postgres:14-alpine///databasename?TC_INITSCRIPT=az-dev-db-schema.sql"
})*/
public class TaskRepositoryTest {

    @Container
    static PostgreSQLContainer  postgreSQLContainer = (PostgreSQLContainer)
            new PostgreSQLContainer(DockerImageName.parse("postgres:14-alpine"))
                    .withInitScript("az-dev-db-schema.sql");


    @Autowired
    TaskRepository taskRepository;

    @DynamicPropertySource
    static void overrideDbConfig(DynamicPropertyRegistry registry){

        registry.add("spring.r2dbc.url", () -> "r2dbc:postgresql://"
                + postgreSQLContainer.getHost() + ":" + postgreSQLContainer.getFirstMappedPort()
                + "/" + postgreSQLContainer.getDatabaseName());
        registry.add("spring.r2dbc.username", () -> postgreSQLContainer.getUsername());
        registry.add("spring.r2dbc.password", () -> postgreSQLContainer.getPassword());
    }


    @Test
    public void testFindTaskBy(){
        StepVerifier.create(taskRepository.findTaskBy())
                .recordWith(ArrayList::new)
                .thenConsumeWhile(x->true)
                .expectRecordedMatches(tasks-> {
                    System.out.println(tasks);
                    return tasks.size() == 5;
                })
                .verifyComplete();
        /*taskRepository.findTaskBy()
                .subscribe(task -> {
                    System.out.println(task.toString());
                });*/
    }


}
