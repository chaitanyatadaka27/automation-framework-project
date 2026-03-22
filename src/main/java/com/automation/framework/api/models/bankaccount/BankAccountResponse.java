package com.automation.framework.api.models.bankaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 🔥 IMPORTANT
public class BankAccountResponse {

    private int id;
    private String name;
    private int balance;
}