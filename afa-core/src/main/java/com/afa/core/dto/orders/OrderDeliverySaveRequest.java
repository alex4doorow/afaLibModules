package com.afa.core.dto.orders;

import com.afa.core.dto.dictionaries.AddressSaveRequest;
import com.afa.core.dto.persons.PersonSaveRequest;
import com.afa.core.enums.DeliveryPaymentTypes;
import com.afa.core.enums.DeliveryPriceTypes;
import com.afa.core.enums.DeliveryTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order delivery save request")
public class OrderDeliverySaveRequest {

    @NotNull
    @Schema(description = "delivery type")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DeliveryTypes deliveryType;

    @NotNull
    @Schema(description = "payment delivery type")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DeliveryPaymentTypes deliveryPaymentType;

    @Schema(description = "delivery price type")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DeliveryPriceTypes deliveryPriceType;

    @NotNull
    @PositiveOrZero
    @Schema(description = "price")
    private BigDecimal price;

    @Valid
    @NotNull
    @Schema(description = "address")
    private AddressSaveRequest address;

    @Valid
    @NotNull
    @Schema(description = "recipient")
    private PersonSaveRequest recipient;

    @Schema(description = "annotation")
    private String annotation;

    @Future
    @Schema(description = "delivery date")
    private LocalDate deliveryDate;

    @Schema(description = "time in")
    private LocalTime timeIn;

    @Schema(description = "time out")
    private LocalTime timeOut;
}
