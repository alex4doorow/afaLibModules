package com.afa.core.dto.integrations.post;

import com.afa.core.dto.dictionaries.AddressDto;
import com.afa.core.enums.OrderPaymentTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCalcTariffRequest {
    private LocalDate calculateDate;
    private BigDecimal totalAmount;
    private Integer weightOfG;
    private String parcelDataName;
    private AddressDto to;
    private OrderPaymentTypes paymentType;
}