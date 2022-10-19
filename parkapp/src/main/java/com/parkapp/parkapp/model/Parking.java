package com.parkapp.parkapp.model;

public class Parking {

    private String name;
    private double longitude;
    private double latitude;
    private int nbPlaceInitial;
    private int nbPlaceRestante;
    private double distanceUtilisateur;

    public Parking(String name, double longitude, double latitude, int nbPlaceInitial) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbPlaceInitial = nbPlaceInitial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getNbPlaceInitial() {
        return nbPlaceInitial;
    }

    public void setNbPlaceInitial(int nbPlaceInitial) {
        this.nbPlaceInitial = nbPlaceInitial;
    }

    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }

    public double getDistanceUtilisateur() {
        return distanceUtilisateur;
    }

    public void setDistanceUtilisateur(double distanceUtilisateur) {
        this.distanceUtilisateur = distanceUtilisateur;
    }

    @Override
    public String toString() {
        return "Parking {" +
                "name='" + name + '\'' +
                ", nbPlaceInitial=" + nbPlaceInitial +
                ", nbPlaceRestante=" + nbPlaceRestante +
                ", distanceUtilisateur=" + distanceUtilisateur +
                '}';
    }
}

