package com.afa.core.dto.integrations.cdek;

import com.afa.core.utils.DateHelper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
public class CdekCalculatorTariffRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateHelper.DATE_FORMAT_CDEK)
    @JsonProperty("date")
    private OffsetDateTime date;

    private Integer type;

    private Integer currency;

    private String lang;

    @JsonProperty("tariff_code")
    private Integer tariffCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("from_location")
    private CdekCalculatorLocationDto fromLocation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("to_location")
    private CdekCalculatorLocationDto toLocation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<CdekCalcPackageRequestDto> packages;

    @JsonProperty("additional_order_types")
    private Set<Integer> additionalOrderTypes;
}
