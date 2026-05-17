package com.afa.core.dto.integrations.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCalcParcelDto {

    @JsonProperty("Название")
    private String name;

    @JsonProperty("Количество")
    private Integer quantity;

    @JsonProperty("Тариф")
    private BigDecimal tariff;

    @JsonProperty("Страховка")
    private BigDecimal insurance;

    @JsonProperty("Доставка")
    private BigDecimal delivery;

    @JsonProperty("ОценкаПолная")
    private BigDecimal fullValuation;

    @JsonProperty("СрокДоставки")
    private String deliveryTerm;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("НаложенныйПлатеж")
    private BigDecimal postpay;

    @JsonProperty("Source")
    private String source;

    @JsonProperty("СрокДоставкиОписание")
    private String deliveryTermDescription;

    @JsonProperty("ПредельныйВес")
    private BigDecimal maxWeight;
}

