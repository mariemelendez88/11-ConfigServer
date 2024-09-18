package com.mycompany.cities_service.service;

import com.mycompany.cities_service.dto.CityDTO;

public interface ICityService {
    
    public CityDTO getCitiesHotels(String name, String country);
    
}
