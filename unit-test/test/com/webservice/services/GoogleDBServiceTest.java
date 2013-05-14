package com.webservice.services;

import com.webservice.repository.JunitSpringConfig;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThat;

public class GoogleDBServiceTest extends JunitSpringConfig {
    @Autowired
    private GoogleDBService googleDBService;

    @Test
    public void shouldGetDistanceForGivenLocation() {
        assertThat(googleDBService.getDistance("Chennai, Tamil Nadu, India", "Bangalore, Karnataka, India","driving"), IsEqual.equalTo("288.13"));
    }
}
