package com.mabdulloh.weather.service;

import com.mabdulloh.weather.domain.response.CurrentWeatherResponse;

public interface WeatherService {
    CurrentWeatherResponse getCurrentWeatherResponse(String cityName, String countryCode);
}
