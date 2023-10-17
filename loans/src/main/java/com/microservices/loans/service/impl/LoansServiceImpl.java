package com.microservices.loans.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.microservices.loans.constants.LoansConstants;
import com.microservices.loans.dto.LoansDto;
import com.microservices.loans.entity.Loans;
import com.microservices.loans.repository.LoansRepository;
import com.microservices.loans.service.ILoansService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()) {
            throw new RuntimeException("Loan already exists for the mobile number: " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    //TODO - transfer this func to a utils class
    private Loans createNewLoan(String mobileNumber) {

        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);

        return newLoan;
    }

    @Override
    public LoansDto getLoan(String mobileNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoan'");
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLoan'");
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLoan'");
    }

}
