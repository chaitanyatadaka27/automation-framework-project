package com.automation.framework.api;

import com.automation.framework.api.dataproviders.TestDataProvider;
import com.automation.framework.api.models.user.UserRequest;
import com.automation.framework.api.models.user.UserResponse;
import com.automation.framework.api.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class UserTest {

    private UserService service;
    private String login;

    @BeforeClass
    public void setup() {
        service = new UserService();
    }

    // CREATE USER
    @Test(priority = 1)
    public void shouldCreateUser() {

        login = "user_" + System.currentTimeMillis();

        UserRequest request = UserRequest.builder()
                .login(login)
                .firstName("Naruto")
                .lastName("Uzumaki")
                .email(login + "@mail.com")
                .activated(true)
                .langKey("en")
                .authorities(List.of("ROLE_USER"))
                .password("password123")
                .build();

        Response response = service.createUser(request);

        assertEquals(response.getStatusCode(), 201);
    }
    //CREATE MULTIPLE USERS USING DATAPROVIDERS
    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)
    public void shouldCreateMultipleUsers(String baseLogin, String firstName, String lastName) {

        String login = baseLogin + "_" + System.currentTimeMillis();
        String email = login + "@mail.com";

        UserRequest request = UserRequest.builder()
                .login(login)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .activated(true)
                .langKey("en")
                .authorities(java.util.List.of("ROLE_USER"))
                .password("password123")
                .build();

        Response response = service.createUser(request);

        assertEquals(response.getStatusCode(), 201);
    }
    // GET ALL USERS
    @Test(priority = 2)
    public void shouldGetAllUsers() {

        Response response = service.getAllUsers();

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.asString().contains("admin"));
    }

    // GET USER BY LOGIN
    @Test(priority = 3)
    public void shouldGetUserByLogin() {

        Response response = service.getUserByLogin(login);

        assertEquals(response.getStatusCode(), 200);

        UserResponse user = response.as(UserResponse.class);

        assertEquals(user.getLogin(), login);
    }

    @Test
    public void shouldNotAllowPatchUser() {

        UserRequest request = UserRequest.builder()
                .firstName("Itachi")
                .build();

        Response response = service.patchUser(login, request);

        assertEquals(response.getStatusCode(), 405); // ✅ correct expectation
    }

    // DELETE USER
    @Test(priority = 6)
    public void shouldDeleteUser() {

        Response response = service.deleteUser(login);

        assertEquals(response.getStatusCode(), 204);
    }

    // NEGATIVE TEST
    @Test
    public void shouldFailForInvalidUser() {

        Response response = service.getUserByLogin("invalid_user_123");

        assertEquals(response.getStatusCode(), 404);
    }
}