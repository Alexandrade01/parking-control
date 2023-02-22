package com.api.parkingcontrol.service.impl;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.model.ParkingSportModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.service.ParkingSpotService;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

	private ParkingSpotRepository repository;

	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		repository = parkingSpotRepository;
	}

	@Override
	public Object save(ParkingSportModel parkingSpotModel) {

		return repository.save(parkingSpotModel);
	}

}
