package com.inklusport;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    void testHealthEndpoint() {
        given()
          .when().get("/api/health")
          .then()
             .statusCode(200)
             .body("application", is("Inklusport Sports Hub"))
             .body("status", is("UP"))
             .body("message", is("API funcionando correctamente"));
    }

}