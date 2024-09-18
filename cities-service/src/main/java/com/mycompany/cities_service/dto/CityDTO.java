package com.mycompany.cities_service.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    
    private Long id_city;
    private String name_city;
    private String continent;
    private String country;
    private String state;
    private List<HotelDTO> hotelList;
    
}
