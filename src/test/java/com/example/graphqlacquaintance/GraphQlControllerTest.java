package com.example.graphqlacquaintance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(GraphQlController.class)
class GraphQlControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void greetingQueryReturnsGreeting() {
        graphQlTester.document("{ greeting(name: \"Анна\") }")
                .execute()
                .path("greeting")
                .entity(String.class)
                .isEqualTo("Привет, Анна! Это ответ Spring for GraphQL.");
    }
}
