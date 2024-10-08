package com.mabdulloh.weather.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CurrentWeatherResponse {
    private Double temperature;
    private Double windSpeed;
    private String windDirection;
    private String cityName;
    private String countryCode;
    private String weather;
    private String winDirectionFull;
}
