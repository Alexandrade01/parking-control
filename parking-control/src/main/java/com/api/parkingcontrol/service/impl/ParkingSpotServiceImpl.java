package com.api.parkingcontrol.service.impl;

import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.service.ParkingSpotService;

public class ParkingSpotServiceImpl implements ParkingSpotService {

	private ParkingSpotRepository repository;

	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		repository = parkingSpotRepository;
	}

}
