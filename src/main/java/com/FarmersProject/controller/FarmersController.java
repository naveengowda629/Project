package com.FarmersProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FarmersProject.models.FarmerDetails;
import com.FarmersProject.service.FarmersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("farmers")
public class FarmersController {
	@Autowired
 FarmersService farmerservice;
	@RequestMapping("/getAll")
	public ResponseEntity <List<FarmerDetails>> getAll() throws JsonMappingException, JsonProcessingException{
		
		List<FarmerDetails> f1= farmerservice.getAllDetails();
		return ResponseEntity.ok(f1);
	}
	@RequestMapping("/post")
	public ResponseEntity<FarmerDetails> postAdd(@RequestBody()FarmerDetails farmerDetails) throws JsonMappingException, JsonProcessingException{
		 FarmerDetails f2= farmerservice.postFarmers(farmerDetails);
		 return ResponseEntity.ok(f2);
	}
	@RequestMapping("/login")
	public ResponseEntity<String> farmerslogin(@RequestBody() FarmerDetails farmerDetails)  throws JsonMappingException, JsonProcessingException{
		String d1= farmerservice.FarmLogin(farmerDetails);
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
	public ResponseEntity<String> farmerssignup(@RequestBody() FarmerDetails farmerDetails)  throws JsonMappingException, JsonProcessingException{
		
	String d1= farmerservice.farmsignup(farmerDetails);
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
