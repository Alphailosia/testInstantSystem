package com.parkapp.parkapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.parkapp.parkapp.model.Parking;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("parkingService")
public class ParkingService {

    @Value("${url.parking.placeremaining}")
    private String uriPlaceRemaining;
    @Value("${url.parkaing.location}")
    private String uriParkingLocation;
    @Value("${distance.from.parking}")
    private int defaultDistance;
    @Value("${earth.radius}")
    private int earthRadius;

    /**
     * Revoie la liste des parking les plus proches de l'utilisateur (à moins d'un kilomètre de distance
     * @param latitude , latitude de l'utilisateur
     * @param longitude , longitude de l'utilisateur
     * @return liste des parkings
     */
    public List<Parking> getParkings(double latitude, double longitude){
        List<Parking> result = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        // récupération des données

        String data = restTemplate.getForObject(uriParkingLocation, String.class);

        // traitement des données
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ArrayNode parkings = (ArrayNode) objectMapper.readTree(data).get("records");

            for(JsonNode node : parkings){

                JsonNode fields = node.get("fields"); // les informations du parking

                String nom = fields.get("nom").textValue();
                double latitudeParking = fields.get("geo_point_2d").get(0).doubleValue();
                double longitudeParking = fields.get("geo_point_2d").get(1).doubleValue();
                int nbPlaceInitial = fields.get("nb_places").intValue();

                // calcule de la distance
                double distance = calculDistance(longitudeParking, latitudeParking,longitude,latitude);

                // ajout dans la list ou non
                if(distance<defaultDistance){
                    Parking parking = new Parking(nom,longitudeParking, latitudeParking, nbPlaceInitial);

                    parking.setDistanceUser(distance);

                    // vérification du nombre de places restantes
                    int nbPlacesRemaining = getNbPlacesRemaining(parking.getName());

                    if(nbPlacesRemaining==0){
                        parking.setNbPlaceRemaining(nbPlaceInitial);
                    }
                    else{
                        parking.setNbPlaceRemaining(nbPlacesRemaining);
                    }

                    result.add(parking);
                }

            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    /**
     * Revoie le nombre de place restante d'un parking, si le parking n'est pas trouvé renvoie 0
     * @param parkingName
     * @return
     */
    private int getNbPlacesRemaining(String parkingName){
        RestTemplate restTemplate = new RestTemplate();

        // récupération des données
        String data = restTemplate.getForObject(uriPlaceRemaining, String.class);

        // traitement des données
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ArrayNode parkings = (ArrayNode) objectMapper.readTree(data).get("records");

            for(JsonNode parking : parkings){
                if (parking.get("fields").get("nom").equals(parkingName)){
                    return parking.get("fields").get("places_restantes").intValue();
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * Methode permettant de calculer la distance entre deux point
     * récupéré sur https://prograide.com/pregunta/75209/calculer-la-distance-entre-deux-points-en-utilisant-la-latitude-et-la-longitude
     * @param longitudeParking
     * @param latitudeParking
     * @param longitudeUser
     * @param latitudeUser
     * @return distance entre la personne et le parking
     */
    private double calculDistance(double longitudeParking, double latitudeParking, double longitudeUser , double latitudeUser ){

        double latDistance = Math.toRadians(latitudeUser - latitudeParking);
        double lonDistance = Math.toRadians(longitudeUser - longitudeParking);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(latitudeParking)) * Math.cos(Math.toRadians(latitudeUser)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c * 1000; // convert to meters

        distance = Math.pow(distance, 2) + Math.pow(0.0, 2);

        return Math.sqrt(distance);

    }


}
