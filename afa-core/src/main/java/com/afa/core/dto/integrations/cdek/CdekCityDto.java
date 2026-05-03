package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@JsonIgnoreProperties
@Data
public class CdekCityDto {
    Integer code;
    String city;
    @JsonProperty("city_uuid")
    UUID cityUuid;
    @JsonProperty("fias_guid")
    UUID fiasUuid;
    @JsonProperty("country_code")
    String countryCode;
    String country;
    String region;
    @JsonProperty("region_code")
    Integer regionCode;
    @JsonProperty("sub_region")
    String subRegion;
    BigDecimal longitude;
    BigDecimal latitude;
    @JsonProperty("time_zone")
    String timeZone;
    @JsonProperty("payment_limit")
    BigDecimal paymentLimit;
}