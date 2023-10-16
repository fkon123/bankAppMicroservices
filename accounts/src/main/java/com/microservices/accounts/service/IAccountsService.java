package com.microservices.accounts.service;

import com.microservices.accounts.dto.CustomerDto;

public interface IAccountsService {

    /*
    * This method is used to create account
    * @param customerDto CustomerDto object
    */
    void createAccount(CustomerDto customerDto);
}
