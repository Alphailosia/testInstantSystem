package com.parkapp.parkapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Parking {

    private String name;
    private double longitude;
    private double latitude;
    private int nbPlaceInitial;
    private int nbPlaceRemaining;
    private double distanceUser;

    public Parking(String name, double longitude, double latitude, int nbPlaceInitial) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbPlaceInitial = nbPlaceInitial;
    }

    @Override
    public String toString() {
        return "Parking {" +
                "name='" + name + '\'' +
                ", nbPlaceInitial=" + nbPlaceInitial +
                ", nbPlaceRemaining=" + nbPlaceRemaining +
                ", distanceUser=" + distanceUser +
                '}';
    }
}

