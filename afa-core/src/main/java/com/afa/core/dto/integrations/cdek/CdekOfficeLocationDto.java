package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CdekOfficeLocationDto {
    @JsonAlias("country_code")
    private String countryCode;
    @JsonAlias("region_code")
    private String regionCode;
    private String region;
    @JsonAlias("city_code")
    private String cityCode;
    private String city;
    @JsonAlias("city_uuid")
    private UUID cityUid;
    @JsonAlias("postal_code")
    private String postalCode;
    private Double longitude;
    private Double latitude;
    @JsonAlias("address")
    private String addressShort;
    @JsonAlias("address_full")
    private String addressFull;
}
