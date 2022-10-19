package com.parkapp.parkapp.service;

import com.parkapp.parkapp.model.Parking;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    @Test
    void getParkings() {

        ParkingService parkingService = new ParkingService();

        List<Parking> test = parkingService.getParkings(46.58595804860371,40.351295426580696);
        assertEquals(test.size(),0);

        test = parkingService.getParkings(46.58595804860371,0.351295426580696);
        assertEquals(test.size(),14);

    }

    @Test
    void calculDistance() {

        ParkingService parkingService = new ParkingService();

        double test = parkingService.calculDistance(46.58595804860371,40.351295426580696, 46.58595804860371,40.351295426580696);
        assertTrue(test<1000);

        test = parkingService.calculDistance(46.58595804860371,0.351295426580696, 46.58595804860371,40.351295426580696);
        assertFalse(test<1000);
    }
}