package com.mycompany.cities_service.controller;

import com.mycompany.cities_service.dto.CityDTO;
import com.mycompany.cities_service.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {
    
    @Autowired
    private ICityService cityServ;
    
    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name_city, @RequestParam String country){
        return cityServ.getCitiesHotels(name_city, country);
    }
    
    
}
