package com.automation.framework.api.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    // BANK ACCOUNT DATA
    @DataProvider(name = "bankAccountData")
    public static Object[][] bankAccountData() {
        return new Object[][]{
                {"Naruto", 1000},
                {"Sasuke", 2000},
                {"Itachi", 3000}
        };
    }

    // USER DATA
    @DataProvider(name = "userData")
    public static Object[][] userData() {
        return new Object[][]{
                {"userA", "Naruto", "Uzumaki"},
                {"userB", "Sasuke", "Uchiha"},
                {"userC", "Itachi", "Uchiha"}
        };
    }
}