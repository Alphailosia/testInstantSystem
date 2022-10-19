package com.parkapp.parkapp.service;

import com.parkapp.parkapp.model.Parking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public class LogService {

    public String afficheList(List<Parking> liste){
        int increment=1;
        String result = "=========== Parkings proches ============= \n";

        for (Parking parking : liste){
            result+="\t"+increment+" -\t"+parking.toString()+"\n";
            increment++;
        }

        result += "=============================================";
        return result;
    }

}
