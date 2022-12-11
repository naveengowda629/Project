package com.FarmersProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FarmersProject.models.CustomerDetails;

import com.FarmersProject.service.CustomerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
		@RequestMapping("/getAll")
		public ResponseEntity <List<CustomerDetails>> getAll() throws JsonMappingException, JsonProcessingException{
			
			List<CustomerDetails> f1= customerservice.getAllDetails();
			return ResponseEntity.ok(f1);
		}
		@RequestMapping("/post")
		public ResponseEntity<CustomerDetails> postAdd(@RequestBody()CustomerDetails customerDetails) throws JsonMappingException, JsonProcessingException{
			CustomerDetails f2= customerservice.postCustomer(customerDetails);
			 return ResponseEntity.ok(f2);
		}
		@RequestMapping("/login")
		public ResponseEntity<String> customerlogin(@RequestBody() CustomerDetails customerDetails)  throws JsonMappingException, JsonProcessingException{
			String d1= customerservice.custLogin(customerDetails);
			if (d1.equals("User not found")) 
			{
				return ResponseEntity.status(403).body(d1); 
			}
			else
			{
				return ResponseEntity.ok(d1);  
			}
		}
		@RequestMapping("/signup")
		public ResponseEntity<String> customersignup(@RequestBody() CustomerDetails customerDetails)  throws JsonMappingException, JsonProcessingException{
			
		String d1= customerservice.custsignup(customerDetails);
		if (d1.equals("User already Exists")) 
		{
			return ResponseEntity.status(403).body(d1); 
		}
		else
		{
			return ResponseEntity.ok(d1);  
		}
	}
	}
	

	


