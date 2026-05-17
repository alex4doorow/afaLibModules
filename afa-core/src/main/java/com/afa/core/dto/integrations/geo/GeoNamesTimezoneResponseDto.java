package com.afa.core.dto.integrations.geo;

import com.afa.core.utils.DateHelper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoNamesTimezoneResponseDto {

    private String timezoneId;

    private String countryCode;

    private String countryName;

    private String time;

    @JsonProperty("lng")
    private Double longitude;

    @JsonProperty("lat")
    private Double latitude;

    private Integer gmtOffset;

    private Integer rawOffset;

    private Integer dstOffset;

    private String sunrise;

    private String sunset;

    public boolean isMoscowOffset() {
        return this.gmtOffset == null || this.gmtOffset == 3;
    }

    public String getTextLocalTime() {

        if (!isMoscowOffset()) {
            return DateHelper.defaultFormatTimeByTimeZone(timezoneId);
        } else {
            return "";
        }
    }

    public static GeoNamesTimezoneResponseDto createEmpty() {
        return new GeoNamesTimezoneResponseDto();
    }
}
