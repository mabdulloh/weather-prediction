package com.mabdulloh.weather.domain.weatherbit;

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
public class CurrentWeatherBitClientResponse extends CurrentWeatherClientResponse {
    @JsonProperty("app_temp")
    private Double temperature;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("weather")
    private Weather weather;

    @JsonProperty("wind_cdir_full")
    private String winDirectionFull;

    @JsonProperty("wind_dir")
    private Double windDirection;

    @JsonProperty("wind_spd")
    private Double windSpeed;
}
