package com.mabdulloh.weather.service;

import com.mabdulloh.weather.client.WeatherClient;
import com.mabdulloh.weather.domain.apininja.CurrentWeatherApiNinjaClientResponse;
import com.mabdulloh.weather.domain.response.CurrentWeatherResponse;
import com.mabdulloh.weather.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiNinjaWeatherService implements WeatherService{

    private final WeatherClient<CurrentWeatherApiNinjaClientResponse> weatherClient;

    @Override
    public CurrentWeatherResponse getCurrentWeatherResponse(String cityName, String countryCode) {
        return Mapper.map(weatherClient.getCurrentWeather(cityName, countryCode));
    }
}
