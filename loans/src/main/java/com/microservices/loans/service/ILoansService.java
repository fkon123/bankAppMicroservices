package com.microservices.loans.service;

import com.microservices.loans.dto.LoansDto;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDto getLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);

}
