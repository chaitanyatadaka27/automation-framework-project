package com.automation.framework.api.auth;

import com.automation.framework.api.models.auth.AuthRequest;
import com.automation.framework.core.config.ConfigReader;
import com.automation.framework.core.constants.APIEndpoints;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthService {

    private static String token;

    public static String getToken() {

        if (token != null) {
            return token;
        }

        log.info("Generating authentication token...");

        AuthRequest request = new AuthRequest(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        token = RestAssured
                .given()
                .baseUri(ConfigReader.get("base.url"))
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post(APIEndpoints.AUTHENTICATIONS)
                .then()
                .statusCode(200)
                .extract()
                .path("id_token");

        if (token == null) {
            throw new RuntimeException("Token is null. Check auth response.");
        }

        log.info("Token generated successfully");
        return token;
    }
}