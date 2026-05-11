package com.afa.core.dto.delivery;

import com.afa.core.dto.orders.OrderSaveRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryCalcParcelAmountsRequest {

    @NotNull
    private OrderSaveRequest order;
}
