package com.FarmersProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmersProject.models.CropsDetails;
@Repository
public interface CropRepository extends JpaRepository<CropsDetails, Integer>{

}
