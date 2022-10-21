package com.parkapp.parkapp.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.parkapp.parkapp.controller.ParkingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ParkingController.class);

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e){
        LOG.error(e.getMessage());
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
