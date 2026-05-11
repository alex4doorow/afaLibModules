package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CdekCalculatorTariffListResponse {

    @JsonProperty("tariff_codes")
    private Set<CdekTariffCodeDto> tariffCodes;

    private List<CdekSystemErrorDto> errors;
    private List<CdekSystemWarningDto> warnings;


}
