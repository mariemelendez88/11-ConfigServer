package com.mycompany.cities_service.service;

import com.mycompany.cities_service.dto.CityDTO;
import com.mycompany.cities_service.model.City;
import com.mycompany.cities_service.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService{
    
    @Autowired
    private IHotelsAPI hotelsAPI;
    
    List<City> cities = new ArrayList<>(); 

    @Override
    //name = same name of the service
    //falbackmethod = method to send in case something doesn't work
    @CircuitBreaker(name="hotels-service", fallbackMethod="fallbackGetCitiesHotel")
    //to retry
    @Retry(name="hotels-service")
    public CityDTO getCitiesHotels(String name_city, String country) {
        
        City city = this.findCity(name_city, country);
        
        CityDTO cityDTO = new CityDTO();

        //create the DTO of city + hotels lists
        cityDTO.setId_city(city.getId_city());
        cityDTO.setName_city(city.getName_city());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        //search the hotel lists in the API and we assign
        cityDTO.setHotelList(hotelsAPI.getHotelsByIdCity(city.getId_city()));
                
        return cityDTO;
        
    }

    public CityDTO fallbackGetCitiesHotel (String name_city, String country, Throwable throwable){
        return new CityDTO(999999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    //public void createException(){
//        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
//    }
    public void createException() {
        throw new RuntimeException("Prueba Resilience y Circuit Breaker");
    }

    
    public City findCity(String name_city, String country){
        this.loadCities();
        for (City c:cities){
            if(c.getName_city().equals(name_city)){
                if(c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }
    
    public void loadCities(){
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L,"Montevideo", "South America", "Uruguay", "Asunción"));
        cities.add(new City(11L,"Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L,"Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L,"Seville", "Europe", "Spain", "Andalucía"));
        cities.add(new City(14L,"Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L,"Valencia", "Europe", "Spain", "alencian Community"));
    }
    
}
