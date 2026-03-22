package com.automation.framework.api.specs;

import com.automation.framework.api.auth.AuthService;
import com.automation.framework.core.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    private RequestSpecFactory() {}

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + AuthService.getToken())
                .build();
    }
}