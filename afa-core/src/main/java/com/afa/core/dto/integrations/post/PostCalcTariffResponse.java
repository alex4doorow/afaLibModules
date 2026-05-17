package com.afa.core.dto.integrations.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCalcTariffResponse {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Отправления")
    private Map<String, PostCalcParcelDto> parcels;

    @JsonProperty("Откуда")
    private PostCalcAddressDto from;

    @JsonProperty("Куда")
    private PostCalcAddressDto to;

    @JsonProperty("Currency")
    private PostCalcCurrencyDto currency;

    @JsonProperty("API")
    private String api;

    @JsonProperty("NumReqToday")
    private Integer numReqToday;

    @JsonProperty("_request")
    private Map<String, String> request;

    @JsonProperty("_vars")
    private Map<String, Object> vars;

    @JsonProperty("_server")
    private Map<String, Object> server;

    @JsonProperty("_timing")
    private Map<String, Object> timing;
}