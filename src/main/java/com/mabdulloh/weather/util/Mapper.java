package com.mabdulloh.weather.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mabdulloh.weather.domain.apininja.CurrentWeatherApiNinjaClientResponse;
import com.mabdulloh.weather.domain.response.CurrentWeatherResponse;
import com.mabdulloh.weather.domain.weatherbit.CurrentWeatherBitClientResponse;
import com.mabdulloh.weather.exception.WeatherException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Mapper {
    private final static ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new WeatherException(e);
        }
    }

    public static String toJson(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new WeatherException(e);
        }
    }

    public String getJsonNode(String json, String key) {
        try {
            return MAPPER.readTree(json).get(key).toPrettyString();
        } catch (JsonProcessingException e) {
            throw new WeatherException(e);
        }
    }

    public static CurrentWeatherResponse map(CurrentWeatherBitClientResponse source) {
        return new CurrentWeatherResponse()
                .setCityName(source.getCityName())
                .setCountryCode(source.getCountryCode())
                .setTemperature(source.getTemperature())
                .setWindDirection(source.getWinDirectionFull())
                .setWindSpeed(source.getWindSpeed())
                .setWeather(source.getWeather().getDescription());
    }

    public static CurrentWeatherResponse map(CurrentWeatherApiNinjaClientResponse source) {
        return new CurrentWeatherResponse()
                .setCityName(source.getCityName())
                .setCountryCode(source.getCountryCode())
                .setTemperature(source.getTemperature())
                .setWindSpeed(source.getWindSpeed())
                .setWindDirection(source.getWindDegrees().toString());
    }
}
