package com.mycompany.cities_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    
    private Long id_hotel;
    private String name_hotel;
    private int stars;
    private Long id_city;
    
}
