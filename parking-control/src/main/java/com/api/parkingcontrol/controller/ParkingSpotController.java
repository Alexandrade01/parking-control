package com.api.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.ParkingSpotDTO;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.service.ParkingSpotService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		super();
		this.parkingSpotService = parkingSpotService;
	}

	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {

		if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");

		}

		if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");

		}

		if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: Parking Spot already registered for this apartment!");

		}

		var parkingSpotModel = new ParkingSpotModel();

		BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);

		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));

	}

	@GetMapping
	public ResponseEntity<Object> getAllParkingSpots() {

		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {

		Optional<ParkingSpotModel> parkingSpotModel = parkingSpotService.findById(id);

		if (!parkingSpotModel.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Conflict: Parking Spot not found !");

		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModel.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneParkingSpot(@PathVariable(value = "id") UUID id) {
		
		Optional<ParkingSpotModel> parkingSpotModel = parkingSpotService.findById(id);

		if (!parkingSpotModel.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Conflict: Parking Spot not found !");

		}

		parkingSpotService.deleteById(id);

		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted!");
	}

}
