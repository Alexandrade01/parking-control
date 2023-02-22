package com.api.parkingcontrol.service;

import com.api.parkingcontrol.model.ParkingSportModel;

import jakarta.transaction.Transactional;

public interface ParkingSpotService {

	@Transactional
	Object save(ParkingSportModel parkingSpotModel);

}
