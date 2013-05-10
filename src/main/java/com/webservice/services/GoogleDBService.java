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

    public int save(String fromAddress, String toAddress, String distance) {
        return googleRepository.save(fromAddress, toAddress, distance);
    }

    public String getDistance(String fromAddress, String toAddress) {
        return googleRepository.getDistance(fromAddress, toAddress);
    }

    public boolean isLocationPresent(String fromAddress, String toAddress) {
        return googleRepository.isLocationPresent(fromAddress, toAddress);
    }
}
