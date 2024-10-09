package com.mabdulloh.weather.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mabdulloh.weather.domain.weatherbit.CurrentWeatherBitClientResponse;
import com.mabdulloh.weather.exception.WeatherException;
import com.mabdulloh.weather.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class WeatherBitClient implements WeatherClient<CurrentWeatherBitClientResponse> {

    private final static String API_KEY = "";
    private final static String BASE_URL = "https://api.weatherbit.io/v2.0";
    private final static RestTemplate REST_TEMPLATE = new RestTemplate();


    @Override
    public CurrentWeatherBitClientResponse getCurrentWeather(String cityName, String countryCode) {
        try {
            final var url = BASE_URL + "/current" + "?city=" + cityName + "&country=" + countryCode + "&key=" + API_KEY;
            final var response = REST_TEMPLATE.getForEntity(url, String.class);
            final var data = Mapper.getJsonNode(response.getBody(), "data");
            return Mapper.fromJson(data, CurrentWeatherBitClientResponse[].class)[0];
        } catch (HttpClientErrorException e) {
            throw new WeatherException(e.toString());
        }
    }
}
