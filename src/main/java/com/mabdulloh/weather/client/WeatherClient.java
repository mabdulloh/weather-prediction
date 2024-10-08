package com.mabdulloh.weather.client;

import com.mabdulloh.weather.domain.CurrentWeatherClientResponse;

public interface WeatherClient<T extends CurrentWeatherClientResponse> {
    T getCurrentWeather(String cityName, String countryCode);
}
