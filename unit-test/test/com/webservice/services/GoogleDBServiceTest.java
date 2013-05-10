package com.webservice.services;


import com.webservice.repository.GoogleRepository;
import com.webservice.repository.JunitSpringConfig;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThat;

public class GoogleDBServiceTest extends JunitSpringConfig {
   @Autowired
    private GoogleDBService googleDBService;

    @Autowired
    private GoogleRepository googleRepository;

     @Test
    public void shouldGetDistanceForGivenLocation(){
         assertThat(googleDBService.getDistance("chennai","bangalore"), IsEqual.equalTo("288.13"));
     }


}
