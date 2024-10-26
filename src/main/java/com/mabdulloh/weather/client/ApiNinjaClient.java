package com.mabdulloh.weather.client;

import com.mabdulloh.weather.domain.GeocodeResponse;
import com.mabdulloh.weather.domain.apininja.CurrentWeatherApiNinjaClientResponse;
import com.mabdulloh.weather.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ApiNinjaClient implements WeatherClient<CurrentWeatherApiNinjaClientResponse>, GeocodeClient {

    private final static String BASE_URL = "https://api.api-ninjas.com/v1";
    private final static RestTemplate REST_TEMPLATE = new RestTemplate();
    private final static String API_KEY = "";

    @Override
    public CurrentWeatherApiNinjaClientResponse getCurrentWeather(String cityName, String countryCode) {
        final var geocode = getGeocode(cityName, countryCode);
        final var url = BASE_URL + "/weather" + "?lat=" + geocode.getLatitude() + "&lon=" + geocode.getLongitude();
        final var headers = setHttpHeaders();
        final var response = REST_TEMPLATE.exchange(url, HttpMethod.GET, headers, String.class);
        return Mapper.fromJson(response.getBody(), CurrentWeatherApiNinjaClientResponse.class)
                .setCityName(cityName)
                .setCountryCode(countryCode);
    }

    @Override
    public GeocodeResponse getGeocode(String cityName, String countryCode) {
        final var url = BASE_URL + "/geocoding" + "?city=" + cityName + "&country=" + countryCode;
        final var headers = setHttpHeaders();
        final var response = REST_TEMPLATE.exchange(url, HttpMethod.GET, headers, String.class);
        return Mapper.fromJson(response.getBody(), GeocodeResponse[].class)[0];
    }

    private static HttpEntity<String> setHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", API_KEY);
        return new HttpEntity<>(headers);
    }
}
