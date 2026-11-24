package com.example.parking.controller;

import com.example.parking.model.ParkingSpot;
import com.example.parking.service.ParkingSpotService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/spots")
public class ParkingSpotController {

    private final ParkingSpotService service;

    public ParkingSpotController(ParkingSpotService service) {
        this.service = service;
    }

    @GetMapping
    public List<ParkingSpot> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ParkingSpot get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ParkingSpot create(@Valid @RequestBody ParkingSpot spot) {
        return service.create(spot);
    }

    @PutMapping("/{id}")
    public ParkingSpot update(@PathVariable Long id, @Valid @RequestBody ParkingSpot spot) {
        return service.update(id, spot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}