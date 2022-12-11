package com.FarmersProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FarmersProject.models.FarmerDetails;


@Repository
public interface FarmersRepository extends JpaRepository<FarmerDetails, Integer> {
	public FarmerDetails getByPhone(long phone);
}
