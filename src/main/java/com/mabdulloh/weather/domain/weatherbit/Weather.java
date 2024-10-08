package com.mabdulloh.weather.domain.weatherbit;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private String icon;
    private String description;
    private String code;
}
