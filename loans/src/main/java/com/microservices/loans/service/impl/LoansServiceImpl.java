package com.microservices.loans.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.springframework.stereotype.Service;

import com.microservices.loans.constants.LoansConstants;
import com.microservices.loans.dto.LoansDto;
import com.microservices.loans.entity.Loans;
import com.microservices.loans.exception.LoanAlreadyExistsException;
import com.microservices.loans.exception.ResourceNotFoundException;
import com.microservices.loans.mapper.LoansMapper;
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
            throw new LoanAlreadyExistsException("Loan already exists for the mobile number: " + mobileNumber);
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
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));

        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return  true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Loan does not exist for the mobile number: " + mobileNumber));
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }

}
