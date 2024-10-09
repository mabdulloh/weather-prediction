package com.mabdulloh.weather.client;

import com.mabdulloh.weather.domain.apininja.CurrentWeatherApiNinjaClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiNinjaClient implements WeatherClient<CurrentWeatherApiNinjaClientResponse> {
    @Override
    public CurrentWeatherApiNinjaClientResponse getCurrentWeather(String cityName, String countryCode) {
        return null;
    }
}
