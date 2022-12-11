package com.FarmersProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FarmersProject.models.FarmerDetails;
import com.FarmersProject.repository.FarmersRepository;


@Service
public class FarmersService {
//	public List<FarmerDetails> getFarmerData(String authKey){
//		List<FarmerDetails> list = new ArrayList<FarmerDetails>();
//		FarmerDetails f = new FarmerDetails("kavan", 1223243, "Bangalore");
//		FarmerDetails f4 = new FarmerDetails("Kumar", 9777556, "Mangalore");
//		
//		list.add(f);
//		list.add(f4);
//		System.out.println(list);
//		return list;
//	
//	}


	@Autowired
	private FarmersRepository farmersrepository;
	
	public double sessionKey()
	{
		return 100000* Math.random();
	}
	public int pass(String password)
	{
		return password.hashCode();
	}
	
	public  List<FarmerDetails> getAllDetails(){
		return farmersrepository.findAll();
	}
	
	public FarmerDetails postFarmers(FarmerDetails farmerDetails){
		return farmersrepository.save(farmerDetails);
	}
	
	public String FarmLogin(FarmerDetails farmerDetails){
		 
		long phone= farmerDetails.getPhone();
		String password = farmerDetails.getPassword();
		int  pass= pass(password);
		
		
		FarmerDetails farmobj= farmersrepository.getByPhone(phone);
		if(farmobj!=null){
			long dbphone=farmobj.getPhone();
			String dbpasssword=farmobj.getPassword();
			int dbpass= pass(dbpasssword);
			
			if(phone==dbphone && pass== dbpass){
				double key = sessionKey();
				FarmerDetails f1= farmersrepository.getByPhone(phone);
				f1.setSessionKey(key);
				farmersrepository.save(f1);
				return "Login Sucessful";	
			}
			
		}
		return 	"User not found";
		
	}

	public String farmsignup(FarmerDetails farmerDetails){
		long phone= farmerDetails.getPhone();
		FarmerDetails farmobj= farmersrepository.getByPhone(phone);
		if(farmobj==null){
			farmersrepository.save(farmerDetails);
			return 	"SignUp Succesful";
		}
        else
        {
        	return 	"User already Exists";	
        }
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

