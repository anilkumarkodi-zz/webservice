package com.webservice.repository;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.junit.Assert.*;

public class GoogleRepositoryTest extends JunitSpringConfig {

    @Autowired
    private GoogleRepository googleRepository;
    private JdbcTemplate template;
    @Autowired
    private DataSource dataSource;

    @Before
    public void setUp() {
        template = new JdbcTemplate(dataSource);
    }

    @Test
    public void shouldGetTheDistanceForGivenLocations() {
        assertThat(googleRepository.getDistance("Chennai, Tamil Nadu, India", "Bangalore, Karnataka, India"), IsEqual.equalTo("288.13"));
    }

    @Test
    public void shouldReturnFalseWhenGivenLocationNotFound() {
        assertFalse(googleRepository.isLocationPresent("abcd", "bdcas"));
    }

    @Test
    public void shouldSaveLocation() {
        googleRepository.save("chennai", "hyderabad", "516");
        assertTrue(googleRepository.isLocationPresent("chennai", "hyderabad"));
    }


}
