package com.parkapp.parkapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.parkapp.parkapp.controller.ParkingController;
import com.parkapp.parkapp.model.Parking;
import com.parkapp.parkapp.service.ParkingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParkingControllerTest {

    @InjectMocks
    ParkingController parkingController;

    @Mock
    ParkingService parkingService;

    @Test
    void getParkings() throws JsonProcessingException {

        List<Parking> test =  new ArrayList<>();

        when(parkingService.getParkings(anyDouble(), anyDouble())).thenReturn(test);

        ResponseEntity<List<Parking>> var =  parkingController.getParkings(46.58595804860371,0.351295426580696);

        assertEquals(test,var.getBody());
        assertEquals(HttpStatus.OK,var.getStatusCode());
    }
}