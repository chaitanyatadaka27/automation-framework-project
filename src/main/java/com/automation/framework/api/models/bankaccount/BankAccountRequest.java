package com.automation.framework.api.models.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequest {
    private Integer id;
    private String name;
    private Integer balance;
}