package com.automation.framework.api;

import com.automation.framework.api.dataproviders.TestDataProvider;
import com.automation.framework.api.models.bankaccount.BankAccountRequest;
import com.automation.framework.api.models.bankaccount.BankAccountResponse;
import com.automation.framework.api.services.BankAccountService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BankAccountTest {

    private BankAccountService service;
    private int accountId;

    @BeforeClass
    public void setup() {
        service = new BankAccountService();
    }

    //  CREATE
    @Test(priority = 1)
    public void shouldCreateBankAccountSuccessfully() {

        BankAccountRequest request = BankAccountRequest.builder()
                .name("Naruto")
                .balance(2000)
                .build();

        Response response = service.createAccount(request);

        assertEquals(response.getStatusCode(), 201);

        BankAccountResponse res = response.as(BankAccountResponse.class);

        accountId = res.getId();

        assertTrue(accountId > 0, "Account ID should be generated");
        assertEquals(res.getName(), "Naruto");
        assertEquals(res.getBalance(), 2000);
    }

    @Test(dataProvider = "bankAccountData", dataProviderClass = TestDataProvider.class)
    public void shouldCreateMultipleAccounts(String name, int balance) {

        BankAccountRequest request = BankAccountRequest.builder()
                .name(name)
                .balance(balance)
                .build();

        Response response = service.createAccount(request);

        assertEquals(response.getStatusCode(), 201);
    }

    //  GET
    @Test(priority = 2, dependsOnMethods = "shouldCreateBankAccountSuccessfully")
    public void shouldGetAccountById() {

        Response response = service.getById(accountId);

        assertEquals(response.getStatusCode(), 200);

        BankAccountResponse res = response.as(BankAccountResponse.class);

        assertEquals(res.getId(), accountId);
    }

    //  PUT (FULL UPDATE)
    @Test(priority = 3, dependsOnMethods = "shouldGetAccountById")
    public void shouldUpdateAccount() {

        BankAccountRequest request = BankAccountRequest.builder()
                .id(accountId)   // 🔥 REQUIRED
                .name("Sasuke")
                .balance(5000)
                .build();

        Response response = service.update(accountId, request);

        assertEquals(response.getStatusCode(), 200);
    }

    //PATCH
    @Test(priority = 4, dependsOnMethods = "shouldUpdateAccount")
    public void shouldPatchAccount() {

        BankAccountRequest request = BankAccountRequest.builder()
                .id(accountId)   // 🔥 REQUIRED
                .name("Itachi")
                .build();

        Response response = service.patch(accountId, request);

        assertEquals(response.getStatusCode(), 200);
    }

    //  DELETE
    @Test(priority = 5, dependsOnMethods = "shouldPatchAccount")
    public void shouldDeleteAccount() {

        Response response = service.delete(accountId);

        assertEquals(response.getStatusCode(), 204);

        // Validate deletion
        Response getResponse = service.getById(accountId);
        assertEquals(getResponse.getStatusCode(), 404);
    }

    //  NEGATIVE TEST
    @Test
    public void shouldCreateAccountEvenWithInvalidData() {

        BankAccountRequest request = BankAccountRequest.builder()
                .name("")
                .balance(-100)
                .build();

        Response response = service.createAccount(request);

        // API is not validating → so expect success
        assertEquals(response.getStatusCode(), 201);
    }
}