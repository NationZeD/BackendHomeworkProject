package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.CityCountryDTO;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityCountryDTO> getAllCitiesWithCountry() {
        List<Object[]> citiesWithCountry = cityRepository.findAllCitiesWithCountry();
        return citiesWithCountry.stream()
                .map(array -> new CityCountryDTO((String) array[0], (String) array[1]))
                .collect(Collectors.toList());
    }
}