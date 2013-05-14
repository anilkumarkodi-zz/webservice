package com.webservice.services;

import com.webservice.repository.GoogleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleDBService {

    private GoogleRepository googleRepository;

    @Autowired
    public GoogleDBService(GoogleRepository googleRepository) {
        this.googleRepository = googleRepository;
    }

    public boolean isLocationPresent(String fromAddress, String toAddress, String travelMode) {
        return googleRepository.isLocationPresent(fromAddress, toAddress, travelMode);
    }

    public String getDistance(String fromAddress, String toAddress, String travelMode) {
        return googleRepository.getDistance(fromAddress, toAddress, travelMode);
    }

    public int save(String fromAddress, String toAddress, String distance, String travelMode) {
        return googleRepository.save(fromAddress, toAddress, distance, travelMode);
    }
}
