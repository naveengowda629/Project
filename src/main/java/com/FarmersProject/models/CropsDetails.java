package com.FarmersProject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class CropsDetails {
	private int farmerId;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cropId;
	private double cropPrice;
	private String cropQuality;
	private String cropName;
	private int cropRating;
	private String cropCategory;
	@ManyToOne
	private FarmerDetails farmerDetails;
	
	public FarmerDetails getFarmerDetails() {
		return farmerDetails;
	}
	public void setFarmerDetails(FarmerDetails farmerDetails) {
		this.farmerDetails = farmerDetails;
	}
	
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public double getCropPrice() {
		return cropPrice;
	}
	public void setCropPrice(double cropPrice) {
		this.cropPrice = cropPrice;
	}
	public String getCropQuality() {
		return cropQuality;
	}
	public void setCropQuality(String cropQuality) {
		this.cropQuality = cropQuality;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public int getCropRating() {
		return cropRating;
	}
	public void setCropRating(int cropRating) {
		this.cropRating = cropRating;
	}
	public String getCropCategory() {
		return cropCategory;
	}
	public void setCropCategory(String cropCategory) {
		this.cropCategory = cropCategory;
	}
	

}
