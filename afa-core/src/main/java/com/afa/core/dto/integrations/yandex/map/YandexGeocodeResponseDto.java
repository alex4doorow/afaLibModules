package com.afa.core.dto.integrations.yandex.map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexGeocodeResponseDto {

    private ResponseDto response;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseDto {
        @JsonProperty("GeoObjectCollection")
        private GeoObjectCollectionDto geoObjectCollection;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeoObjectCollectionDto {
        @JsonProperty("featureMember")
        private List<FeatureMemberDto> featureMembers;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FeatureMemberDto {
        @JsonProperty("GeoObject")
        private GeoObjectDto geoObject;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeoObjectDto {
        @JsonProperty("Point")
        private PointDto point;
        private MetaDataPropertyDto metaDataProperty;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PointDto {
        @JsonProperty("pos")
        private String position;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MetaDataPropertyDto {
        @JsonProperty("GeocoderMetaData")
        private GeocoderMetaDataDto geocoderMetaData;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeocoderMetaDataDto {
        @JsonProperty("Address")
        private AddressDto address;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressDto {
        @JsonProperty("country_code")
        private String countryCode;
        private String formatted;
    }

    public static YandexGeocodeResponseDto createEmpty() {
        return YandexGeocodeResponseDto.builder()
                .response(
                        ResponseDto.builder()
                                .geoObjectCollection(
                                        GeoObjectCollectionDto.builder()
                                                .featureMembers(List.of())
                                                .build()
                                )
                                .build()
                )
                .build();
    }
}
