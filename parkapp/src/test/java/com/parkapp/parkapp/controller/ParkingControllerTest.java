package com.parkapp.parkapp.controller;

import com.parkapp.parkapp.controller.ParkingController;
import com.parkapp.parkapp.model.Parking;
import com.parkapp.parkapp.service.ParkingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParkingControllerTest {

    @Autowired
    ParkingController parkingController;

    @Test
    void getParkings() {

        ParkingService parkingService = mock(ParkingService.class);
        List<Parking> test =  new ArrayList<>();

        when(parkingService.getParkings(anyDouble(), anyDouble())).thenReturn(test);

        parkingService.getParkings(46.58595804860371,0.351295426580696);

        assertEquals(14,test.size());
    }
}