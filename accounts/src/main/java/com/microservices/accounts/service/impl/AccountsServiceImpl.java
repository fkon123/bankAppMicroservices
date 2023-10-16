package com.microservices.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.microservices.accounts.dto.CustomerDto;
import com.microservices.accounts.repository.AccountsRepository;
import com.microservices.accounts.repository.CustomerRepository;
import com.microservices.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
