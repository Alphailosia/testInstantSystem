package com.parkapp.parkapp.controller;

import com.parkapp.parkapp.model.Parking;
import com.parkapp.parkapp.service.LogService;
import com.parkapp.parkapp.service.ParkingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {

    @RequestMapping(value = "/parkings",method = RequestMethod.GET)
    public String getParkings(@RequestParam double latitude, @RequestParam double longitude){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.parkapp.parkapp");
        context.refresh();

        // Service de recupération des parkings
        ParkingService parkingService = context.getBean(ParkingService.class);
        List<Parking> parkings = parkingService.getParkings(latitude, longitude);

        // Service de log
        LogService logService = context.getBean(LogService.class);
        return logService.afficheList(parkings);
    }
}
