package com.mycompany.cities_service.repository;

import com.mycompany.cities_service.dto.HotelDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//use the same name that app in eureka
//so, it is not necessary to configure the URL
@FeignClient(name="hotels-service")
public interface IHotelsAPI {
    
    @GetMapping("hotels/{id_city}")
    List<HotelDTO> getHotelsByIdCity (@PathVariable("id_city") Long id_city);
    
}
