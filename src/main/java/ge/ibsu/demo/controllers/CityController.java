package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.CityCountryDTO;
import ge.ibsu.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/with-country")
    public List<CityCountryDTO> getAllCitiesWithCountry() {
        return cityService.getAllCitiesWithCountry();
    }
}