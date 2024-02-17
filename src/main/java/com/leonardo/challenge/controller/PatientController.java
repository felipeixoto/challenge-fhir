package com.leonardo.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.challenge.model.Address;
import com.leonardo.challenge.service.ConsumerService;

@RestController
@RequestMapping("/api/cep")
public class PatientController {

	@Autowired
	private ConsumerService service;

	@GetMapping("/{cepSearch}")
	private ResponseEntity<?> getAddressInformation(@PathVariable("cepSearch") String cepSearch) {
		Address address = service.getAddress(cepSearch);
		return ResponseEntity.ok(address);
	}

}