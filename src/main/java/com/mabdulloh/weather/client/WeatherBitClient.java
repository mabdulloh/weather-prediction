package com.mabdulloh.weather.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mabdulloh.weather.domain.weatherbit.CurrentWeatherBitClientResponse;
import com.mabdulloh.weather.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class WeatherBitClient implements WeatherClient<CurrentWeatherBitClientResponse> {

    private final static String API_KEY = "c1eba6ff6e1d4987a4f8dcbe03d10018";
    private final static String BASE_URL = "https://api.weatherbit.io/v2.0";
    private final static RestTemplate REST_TEMPLATE = new RestTemplate();
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Override
    public CurrentWeatherBitClientResponse getCurrentWeather(String cityName, String countryCode) {
        try {
            final var url = BASE_URL + "/current" + "?city=" + cityName + "&country=" + countryCode + "&key=" + API_KEY;
            final var response = REST_TEMPLATE.getForEntity(url, String.class);
            final var data = OBJECT_MAPPER.readTree(response.getBody()).get("data");
            return OBJECT_MAPPER.convertValue(data, CurrentWeatherBitClientResponse[].class)[0];
        } catch (HttpClientErrorException | JsonProcessingException e) {
            throw new WeatherException(e.toString());
        }
    }
}
