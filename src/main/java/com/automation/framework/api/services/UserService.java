package com.automation.framework.api.services;

import com.automation.framework.api.client.RestClient;
import com.automation.framework.core.constants.APIEndpoints;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

    public Response createUser(Object request) {
        log.info("Creating user");
        return RestClient.post(APIEndpoints.USERS, request);
    }

    public Response getAllUsers() {
        log.info("Fetching all users");
        return RestClient.get(APIEndpoints.USERS);
    }

    public Response getUserByLogin(String login) {
        log.info("Fetching user -> {}", login);
        return RestClient.get(APIEndpoints.USERS + "/" + login);
    }

    public Response updateUser(Object request) {
        log.info("Updating user");
        return RestClient.put(APIEndpoints.USERS, request);
    }

    public Response patchUser(String login, Object request) {
        log.info("Patching user -> {}", login);
        return RestClient.patch(APIEndpoints.USERS + "/" + login, request);
    }

    public Response deleteUser(String login) {
        log.info("Deleting user -> {}", login);
        return RestClient.delete(APIEndpoints.USERS + "/" + login);
    }
}