package com.afa.core.dto.orders;

import com.afa.core.enums.OrderPaymentTypes;
import com.afa.core.enums.OrderSourceTypes;
import com.afa.core.enums.OrderStatusTypes;
import com.afa.core.enums.OrderTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order")
public class OrderChangeStatusSaveRequest {

    @NotNull
    @Schema(description = "order type", example = "ORDER")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OrderTypes type;

    @NotNull
    @Schema(description = "source type", example = "CALL")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OrderSourceTypes sourceType;

    @NotNull
    @Schema(description = "payment type", example = "PREPAYMENT")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OrderPaymentTypes paymentType;

    @NotNull
    @PositiveOrZero
    @Schema(description = "product category id")
    private Long productCategoryId;

    @NotNull
    @Schema(description = "status")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OrderStatusTypes status;

    @Schema(description = "annotation")
    private String annotation;

    @Schema(description = "track code")
    private String trackCode;
}
