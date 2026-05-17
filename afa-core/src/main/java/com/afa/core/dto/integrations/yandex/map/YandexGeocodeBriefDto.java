package com.afa.core.dto.integrations.yandex.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YandexGeocodeBriefDto {

    @Schema(description = "country code")
    private String countryCode;

    @Schema(description = "address line")
    private String addressLine;

    @Schema(description = "position [longitude, latitude]")
    private Map<String, String> position;

    public static YandexGeocodeBriefDto createEmpty() {
        return YandexGeocodeBriefDto.builder()
                .position(Map.of("longitude", "", "latitude", ""))
                .build();
    }
}
