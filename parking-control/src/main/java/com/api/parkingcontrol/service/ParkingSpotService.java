package com.api.parkingcontrol.service;

import java.util.List;

import com.api.parkingcontrol.model.ParkingSpotModel;

import jakarta.transaction.Transactional;

public interface ParkingSpotService {

	@Transactional
	Object save(ParkingSpotModel parkingSpotModel);

	boolean existsByLicensePlateCar(String licensePlateCar);

	boolean existsByParkingSpotNumber(String licensePlateCar);

	boolean existsByApartmentAndBlock(String licensePlateCar, String block);

	List<ParkingSpotModel> findAll();

}
