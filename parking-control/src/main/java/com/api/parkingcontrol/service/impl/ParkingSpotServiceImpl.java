package com.api.parkingcontrol.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.service.ParkingSpotService;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

	private ParkingSpotRepository repository;

	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		repository = parkingSpotRepository;
	}

	@Override
	public Object save(ParkingSpotModel parkingSpotModel) {

		return repository.save(parkingSpotModel);
	}

	@Override
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		
		return repository.existsByLicensePlateCar(licensePlateCar);
	}

	@Override
	public boolean existsByParkingSpotNumber(String licensePlateCar) {
		
		return repository.existsByParkingSpotNumber(licensePlateCar);
	}

	@Override
	public boolean existsByApartmentAndBlock(String licensePlateCar, String block) {
		
		return repository.existsByApartmentAndBlock(licensePlateCar, block);
	}

	@Override
	public List<ParkingSpotModel> findAll() {
		
		return repository.findAll();
	}

}
