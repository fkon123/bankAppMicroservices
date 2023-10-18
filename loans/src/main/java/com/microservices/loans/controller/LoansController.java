package com.microservices.loans.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.microservices.loans.constants.LoansConstants;
import com.microservices.loans.dto.LoansDto;
import com.microservices.loans.dto.ResponseDto;
import com.microservices.loans.service.ILoansService;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class LoansController {

	private ILoansService iLoansService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createLoan(@RequestParam String mobileNumber) {
		iLoansService.createLoan(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));

	}

	@GetMapping("/fetch")
	public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber) {

		LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(loansDto);
	}

	@PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto) {
        boolean isUpdated = iLoansService.updateLoan(loansDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }



	}
