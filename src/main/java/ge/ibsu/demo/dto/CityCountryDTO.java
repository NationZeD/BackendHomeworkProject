package ge.ibsu.demo.dto;

public class CityCountryDTO {

    private String cityName;
    private String countryName;

    public CityCountryDTO() {
    }

    public CityCountryDTO(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}