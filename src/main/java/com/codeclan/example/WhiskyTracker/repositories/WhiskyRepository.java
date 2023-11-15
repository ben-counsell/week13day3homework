package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    public List<Whisky> findByYear(int year);
    public List<Whisky> findByDistilleryNameAndDistilleryWhiskiesYear(String distillery, int year);

    public List<Whisky> findByDistilleryRegion(String region);
}