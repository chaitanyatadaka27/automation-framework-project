package com.automation.framework.api.client;

import com.automation.framework.api.specs.RequestSpecFactory;
import com.automation.framework.core.exceptions.FrameworkException;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class RestClient {

    public static Response post(String endpoint, Object body) {

        log.info("POST -> {}", endpoint);

        Response response = given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(body)
                .when()
                .post(endpoint);

        log.info("Status -> {}", response.getStatusCode());
        response.prettyPrint();
        if (response == null) {
            throw new FrameworkException("API response is null");
        }
        return response;
    }

    public static Response get(String endpoint) {

        log.info("GET -> {}", endpoint);

        Response response = given()
                .spec(RequestSpecFactory.getRequestSpec())
                .when()
                .get(endpoint);

        log.info("Status -> {}", response.getStatusCode());
        response.prettyPrint();
        if (response == null) {
            throw new FrameworkException("API response is null");
        }
        return response;
    }

    public static Response put(String endpoint, Object body) {

        log.info("PUT -> {}", endpoint);

        Response response = given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(body)
                .when()
                .put(endpoint);

        log.info("Status -> {}", response.getStatusCode());
        response.prettyPrint();
        if (response == null) {
            throw new FrameworkException("API response is null");
        }
        return response;
    }

    public static Response patch(String endpoint, Object body) {

        log.info("PATCH -> {}", endpoint);

        Response response = given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(body)
                .when()
                .patch(endpoint);

        log.info("Status -> {}", response.getStatusCode());
        response.prettyPrint();
        if (response == null) {
            throw new FrameworkException("API response is null");
        }
        return response;
    }

    public static Response delete(String endpoint) {

        log.info("DELETE -> {}", endpoint);

        Response response = given()
                .spec(RequestSpecFactory.getRequestSpec())
                .when()
                .delete(endpoint);

        log.info("Status -> {}", response.getStatusCode());
        response.prettyPrint();
        if (response == null) {
            throw new FrameworkException("API response is null");
        }
        return response;
    }
}