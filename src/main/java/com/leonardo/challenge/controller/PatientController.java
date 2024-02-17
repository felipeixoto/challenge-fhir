package com.leonardo.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.challenge.model.Address;
import com.leonardo.challenge.model.vo.v1.PatientVo;
import com.leonardo.challenge.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping("/cep/{cepSearch}")
	private ResponseEntity<?> getAddressInformation(@PathVariable("cepSearch") String cepSearch) {
		Address address = service.getAddress(cepSearch);
		return ResponseEntity.ok(address);
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> findPatient(@PathVariable("id") Long id) {
		PatientVo address = service.findPatient(id);
		return ResponseEntity.ok(address);
	}

}