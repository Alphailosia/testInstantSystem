package com.parkapp.parkapp.service;

import com.parkapp.parkapp.model.Parking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public class LogService {

    public String afficheList(List<Parking> liste){
        String result = "=========== Parkings proches ============= \n";

        for (Parking parking : liste){
            result+="\t-\t"+parking.toString()+"\n";
        }

        result += "=============================================";
        return result;
    }

}
