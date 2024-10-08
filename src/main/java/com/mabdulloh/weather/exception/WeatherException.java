package com.mabdulloh.weather.exception;

public class WeatherException extends RuntimeException {

    public WeatherException() {
        super();
    }

    public WeatherException(String message) {
        super(message);
    }

    public WeatherException(Exception e) {
        super(e);
    }

    public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }
}
