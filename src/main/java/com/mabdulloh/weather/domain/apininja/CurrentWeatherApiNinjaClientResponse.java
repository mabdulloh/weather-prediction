package com.mabdulloh.weather.domain.apininja;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mabdulloh.weather.domain.CurrentWeatherClientResponse;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherApiNinjaClientResponse extends CurrentWeatherClientResponse {
    private Double windSpeed;
    private Double windDegrees;
    private Double temperature;
    private String cityName;
    private String countryCode;
}
