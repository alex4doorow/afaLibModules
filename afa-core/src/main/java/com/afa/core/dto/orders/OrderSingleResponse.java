package com.afa.core.dto.orders;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Schema(description = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderSingleResponse extends BaseResponse {

    @Schema(description = "order with all data")
    private final OrderDto order;

    public OrderSingleResponse(final OrderDto order) {
        super();
        this.order = order;
    }
}