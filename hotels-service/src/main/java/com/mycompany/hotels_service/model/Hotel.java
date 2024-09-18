package com.mycompany.hotels_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    
    private Long id_hotel;
    private String name_hotel;
    private int stars;
    private Long id_city;
    
}
