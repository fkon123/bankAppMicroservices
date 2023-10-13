package com.microservices.accounts.dto;

import lombok.*;

@Data
public class AccountsDto {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}