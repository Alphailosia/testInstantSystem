package com.parkapp.parkapp.controller;

import com.parkapp.parkapp.model.Parking;
import com.parkapp.parkapp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @RequestMapping(value = "/parkings",method = RequestMethod.GET)
    public HttpEntity<List<Parking>> getParkings(@RequestParam double latitude, @RequestParam double longitude){
        List<Parking> parkings = parkingService.getParkings(latitude, longitude);
        return new HttpEntity<>(parkings);
    }
}
