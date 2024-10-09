package com.mabdulloh.weather.domain.apininja;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("wind_speed")
    private Double windSpeed;
    @JsonProperty("wind_degrees")
    private Double windDegrees;
    @JsonProperty("temp")
    private Double temperature;
    private String cityName;
    private String countryCode;
}
