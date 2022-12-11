package com.FarmersProject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class FarmerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int farmerId;
	private String farmerName;
	private long farmerAadharNumber;
	private String farmerPlace; 
	private long phone;
	private String password;
	private double sessionKey;
//	@OneToMany
//	private List<CropsDetails> cropsdetails;
	
//	public List<CropsDetails> getCropsdetails() {
//		return cropsdetails;
//	}
//
//	public void setCropsdetails(List<CropsDetails> cropsdetails) {
//		this.cropsdetails = cropsdetails;
//	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(double sessionKey) {
		this.sessionKey = sessionKey;
	}

	public int getFarmerId() {
		return farmerId;
	}



	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public FarmerDetails(String farmerName, long farmerAadharNumber, String farmerPlace, long phone, String password,
			double sessionKey) {
		super();
		this.farmerName = farmerName;
		this.farmerAadharNumber = farmerAadharNumber;
		this.farmerPlace = farmerPlace;
		this.phone = phone;
		this.password = password;
		this.sessionKey = sessionKey;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public long getFarmerAadharNumber() {
		return farmerAadharNumber;
	}

	public void setFarmerAadharNumber(long farmerAadharNumber) {
		this.farmerAadharNumber = farmerAadharNumber;
	}

	public String getFarmerPlace() {
		return farmerPlace;
	}

	public void setFarmerPlace(String farmerPlace) {
		this.farmerPlace = farmerPlace;
	}

	public FarmerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
