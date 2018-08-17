package yahoo.garg.sharad.springmockitojunit.test.controllers;


import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredITTest {
    @Test
    public void givenUrl() {
        given().when().get("http://localhost:8080/SpringMockitoJunit/test").then().assertThat().statusCode(400);
        System.out.println("Invoked");
    }
}
