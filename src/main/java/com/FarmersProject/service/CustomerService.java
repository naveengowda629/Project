package com.FarmersProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FarmersProject.models.CustomerDetails;
import com.FarmersProject.repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepository;
	
	public double sessionKey()
	{
		return 100000* Math.random();
	}
	public int pass(String password)
	{
		return password.hashCode();
	}
	
	
	
	public  List<CustomerDetails> getAllDetails(){
		return customerrepository.findAll();
	}
	
	public CustomerDetails postCustomer(CustomerDetails customerDetails){
		return customerrepository.save(customerDetails);
	}
	
	public String custLogin(CustomerDetails customerDetails){
		 
		long phone= customerDetails.getPhone();
		String password = customerDetails.getPassword();
		int  pass= pass(password);
		
		
		CustomerDetails custobj= customerrepository.getByPhone(phone);
		if(custobj!=null){
			long dbphone=custobj.getPhone();
			String dbpasssword=custobj.getPassword();
			int dbpass= pass(dbpasssword);
			
			if(phone==dbphone && pass== dbpass){
				double key = sessionKey();
				CustomerDetails f1= customerrepository.getByPhone(phone);
				f1.setSessionKey(key);
				customerrepository.save(f1);
				return "Login Sucessful";	
			}
			
		}
		return 	"User not found";
		
	}

	public String custsignup(CustomerDetails customerDetails){
		long phone= customerDetails.getPhone();
		CustomerDetails custobj= customerrepository.getByPhone(phone);
		if(custobj==null){
			customerrepository.save(customerDetails);
			return 	"SignUp Succesful";
		}
        else
        {
        	return 	"User already Exists";	
        }
		}
	}
	


