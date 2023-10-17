package com.microservices.loans.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.microservices.loans.constants.LoansConstants;
import com.microservices.loans.dto.LoansDto;
import com.microservices.loans.dto.ResponseDto;
import com.microservices.loans.service.ILoansService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
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



}