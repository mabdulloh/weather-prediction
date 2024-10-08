package com.mabdulloh.weather.controller;

import com.mabdulloh.weather.domain.response.CurrentWeatherResponse;
import com.mabdulloh.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weathers")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(value = "/current")
    public CurrentWeatherResponse getCurrentWeather(@RequestParam String cityName,
                                                     @RequestParam String countryCode) {
        return weatherService.getCurrentWeatherResponse(cityName, countryCode);
    }
}
