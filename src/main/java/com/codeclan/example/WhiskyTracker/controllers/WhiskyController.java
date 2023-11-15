package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskiesByYear(@RequestParam(name="year") int year) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/distilleries")
    public ResponseEntity<List<Whisky>> findByDistilleryAndYear(@RequestParam(name="distillery") String distillery, @RequestParam(name="year") int year) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndDistilleryWhiskiesYear(distillery, year), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/region")
    public ResponseEntity<List<Whisky>> findByRegion(@RequestParam(name="region") String region) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }
}
