package com.parkapp.parkapp.service;

import com.parkapp.parkapp.model.Parking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParkingServiceTest {

    @InjectMocks
    ParkingService parkingService;

    @Mock
    RestTemplate restTemplate;

    @Test
    void getParkings() {

        String test;

        when(restTemplate.getForObject(anyString(),any())).thenReturn(test="appelé");

        List<Parking> parkings = parkingService.getParkings(46.58595804860371,0.351295426580696);
        assertEquals(test,"appelé");
        assertEquals(14,parkings.size());
    }
}