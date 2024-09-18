package com.mycompany.cities_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    
    private Long id_city;
    private String name_city;
    private String continent;
    private String country;
    private String state;
    
}
