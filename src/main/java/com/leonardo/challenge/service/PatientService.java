package com.leonardo.challenge.service;

import java.util.logging.Logger;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leonardo.challenge.exception.handler.RestTemplateResponseErrorHandler;
import com.leonardo.challenge.model.vo.v1.PatientVo;

@Service
public class PatientService {

	private Logger logger = Logger.getLogger(PatientService.class.getName());

	public PatientVo findById(Long id) {

		logger.info("Finding patient by ID: " + id);
		
		String url = "http://hapi.fhir.org/baseR4/Patient/44471637/_history/" + id;
		RestTemplate restTemplate = new RestTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler()).build();

		ResponseEntity<PatientVo> response = restTemplate.exchange(url, HttpMethod.GET, null, PatientVo.class);
		
		return response.getBody();
	}

}
