package com.example.parking.service;

import com.example.parking.model.ParkingSpot;
import com.example.parking.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;
import com.example.parking.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository repository;

    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public List<ParkingSpot> getAll() {
        return repository.findAll();
    }

    public ParkingSpot getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("找不到車位：" + id));
    }

    public ParkingSpot create(ParkingSpot spot) {
        spot.setStatus("AVAILABLE");
        return repository.save(spot);
    }

    public ParkingSpot update(Long id, ParkingSpot spot) {
        ParkingSpot existing = getById(id);
        existing.setCode(spot.getCode());
        existing.setArea(spot.getArea());
        if (spot.getStatus() != null) {
            existing.setStatus(spot.getStatus());
        }
        repository.update(existing);
        return existing;
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}