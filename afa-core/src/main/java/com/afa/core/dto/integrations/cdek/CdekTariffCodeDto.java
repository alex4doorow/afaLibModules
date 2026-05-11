package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class CdekTariffCodeDto {

    @JsonAlias("delivery_sum")
    private BigDecimal deliverySum;

    @JsonAlias("period_min")
    private Integer periodMin;

    @JsonProperty("period_max")
    private Integer periodMax;

    @JsonProperty("calendar_min")
    private Integer calendarMin;

    @JsonProperty("calendar_max")
    private Integer calendarMax;

    @JsonProperty("weight_calc")
    private Integer weightCalc;

    private String currency;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<CdekCalcAdditionalServiceDto> services;

    @JsonProperty("total_sum")
    private BigDecimal totalSum;

    private List<CdekCalcPackageRequestDto> packages;
}
