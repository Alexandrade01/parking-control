package com.api.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.model.ParkingSpotModel;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
	
	boolean existsByLicensePlateCar(String LicensePlateCar);
	boolean existsByParkingSpotNumber(String ParkingSpotNumber);
	boolean existsByApartmentAndBlock(String apartment, String block);

}
