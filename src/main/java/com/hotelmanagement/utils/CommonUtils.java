package com.hotelmanagement.utils;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommonUtils {


public String generateUUID(){
    
    UUID uuid = Generators.timeBasedGenerator().generate();
    return uuid.toString();
}

}
