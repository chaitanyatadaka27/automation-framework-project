package com.automation.framework.api.services;

import com.automation.framework.api.client.RestClient;
import com.automation.framework.core.constants.APIEndpoints;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankAccountService {

    public Response createAccount(Object request) {
        log.info("Creating bank account");
        return RestClient.post(APIEndpoints.BANK_ACCOUNTS, request);
    }

    public Response getById(int id) {
        log.info("Fetching account by id -> {}", id);
        return RestClient.get(APIEndpoints.BANK_ACCOUNTS + "/" + id);
    }

    public Response update(int id, Object request) {
        log.info("Updating account -> {}", id);
        return RestClient.put(APIEndpoints.BANK_ACCOUNTS + "/" + id, request);
    }

    public Response patch(int id, Object request) {
        log.info("Patching account -> {}", id);
        return RestClient.patch(APIEndpoints.BANK_ACCOUNTS + "/" + id, request);
    }

    public Response delete(int id) {
        log.info("Deleting account -> {}", id);
        return RestClient.delete(APIEndpoints.BANK_ACCOUNTS + "/" + id);
    }
}