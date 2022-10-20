package com.parkapp.parkapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    void getParkings() throws JsonProcessingException{

        String test;

        parkingService.setUriParkingLocation("https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilite-parkings-grand-poitiers-donnees-metiers&rows=1000&facet=nom_du_parking&facet=zone_tarifaire&facet=statut2&facet=statut3");
        parkingService.setDefaultDistance(1000);
        parkingService.setEarthRadius(6371);
        parkingService.setUriPlaceRemaining("https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom");

        when(restTemplate.getForObject(anyString(),any())).thenReturn(test="appelé");

        List<Parking> parkings = parkingService.getParkings(46.58595804860371,0.351295426580696); // le data set est celui de poitier donc les coordonnée rentré sont celle de la ville de poitiers
        assertEquals(test,"appelé");
        assertTrue(!parkings.isEmpty());

        parkings = parkingService.getParkings(46.58595804860371,40.351295426580696); // les coordonnée rentré ne sont pas celle de la ville de poitiers donc rien n'est attendue
        assertTrue(parkings.isEmpty());
    }
}