package com.afa.core.dto.delivery;

import com.afa.core.enums.DeliveryTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPriceDto {

    private DeliveryTypes deliveryType;

    private String annotation;

    private BigDecimal price;

}
