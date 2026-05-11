package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CdekCalcResponseAdditionalServiceDto {
    private String code;
    private String parameter;
    private BigDecimal sum;
    @JsonAlias("total_sum")
    private BigDecimal totalSum;
}
