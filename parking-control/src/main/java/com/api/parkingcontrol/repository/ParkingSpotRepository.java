package com.api.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.model.ParkingSportModel;

public interface ParkingSpotRepository extends JpaRepository<ParkingSportModel, UUID> {

}
