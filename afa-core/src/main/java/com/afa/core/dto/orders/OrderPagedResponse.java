package com.afa.core.dto.orders;

import com.afa.core.dto.BasePagedResponse;
import com.afa.core.enums.AmountTypes;
import com.afa.core.enums.ReportPeriodTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Collections;
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
    private final Map<AmountTypes, BigDecimal> totalAmounts;

    @Schema(description = "period")
    private final ReportPeriodTypes periodType;

    public OrderPagedResponse(
            final long totalElements, final int totalPages,
            final boolean hasPrev, final boolean hasNext,
            final List<OrderDto> orders,
            final Map<AmountTypes, BigDecimal> totalAmounts,
            final ReportPeriodTypes periodType) {
        super(totalElements, totalPages, hasPrev, hasNext);
        this.orders = orders;
        this.totalAmounts = totalAmounts;
        this.periodType = periodType;
    }

    private OrderPagedResponse() {
        super(0, 0, false, false);
        this.orders = Collections.emptyList();
        this.totalAmounts = Collections.emptyMap();
        this.periodType = ReportPeriodTypes.ANY_PERIOD;
    }

    public static OrderPagedResponse createEmpty() {
        return new OrderPagedResponse();
    }
}