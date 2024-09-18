package com.mycompany.hotels_service.controller;

import com.mycompany.hotels_service.model.Hotel;
import com.mycompany.hotels_service.service.IHotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    
    @Autowired
    private IHotelService hotelServ;
    
    @GetMapping("/{id_city}")
    public List<Hotel> getHotelsByIdCity (@PathVariable Long id_city){
        return hotelServ.getHotelsByIdCity(id_city);
    }
    
}
