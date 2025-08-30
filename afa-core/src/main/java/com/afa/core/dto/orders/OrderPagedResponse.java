package com.afa.core.dto.orders;

import com.afa.core.dto.BasePagedResponse;
import com.afa.core.enums.OrderAmountTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=false)
@Schema(description = "order response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderPagedResponse extends BasePagedResponse {

    @Schema(description = "order list with all data")
    private final List<OrderDto> orders;

    @Schema(description = "total amounts")
    private final Map<OrderAmountTypes, BigDecimal> totalAmounts;

    public OrderPagedResponse(
            final long totalElements, final int totalPages,
            final boolean hasPrev, final boolean hasNext,
            final List<OrderDto> orders,
            final Map<OrderAmountTypes, BigDecimal> totalAmounts) {
        super(totalElements, totalPages, hasPrev, hasNext);
        this.orders = orders;
        this.totalAmounts = totalAmounts;
    }
}