package com.leonardo.challenge.service;

import java.util.logging.Logger;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leonardo.challenge.model.Address;

@Service
public class ConsumerService {

	private Logger logger = Logger.getLogger(ConsumerService.class.getName());
	
    public Address getAddress(String cep) {
        String url = "https://viacep.com.br/ws/"+cep+"/json/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Address> response = restTemplate.exchange(url, HttpMethod.GET, null, Address.class);
        return response.getBody();
    }

}
