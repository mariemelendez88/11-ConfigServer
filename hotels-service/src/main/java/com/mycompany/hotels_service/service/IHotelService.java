package com.mycompany.hotels_service.service;

import com.mycompany.hotels_service.model.Hotel;
import java.util.List;

public interface IHotelService {
    
    public List<Hotel> getHotelsByIdCity (Long id_city);
    
}
