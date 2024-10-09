package com.mabdulloh.weather.client;

import com.mabdulloh.weather.domain.GeocodeResponse;

public interface GeocodeClient {
    GeocodeResponse getGeocode(String cityName, String countryCode);
}
