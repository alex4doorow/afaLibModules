package com.afa.core.dto.delivery;

import com.afa.core.enums.DeliveryTypes;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPricesRequest {

    @NotNull
    private DeliveryTypes deliveryType;
}
