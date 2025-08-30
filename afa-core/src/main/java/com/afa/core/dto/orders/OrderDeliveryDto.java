package com.afa.core.dto.orders;

import com.afa.core.dto.dictionaries.AddressDto;
import com.afa.core.dto.dictionaries.DeliveryTypeDto;
import com.afa.core.dto.persons.PersonFullDto;
import com.afa.core.enums.DeliveryPaymentTypes;
import com.afa.core.enums.DeliveryPriceTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Order delivery info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class OrderDeliveryDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "delivery type")
    private DeliveryTypeDto deliveryType;

    @Schema(description = "delivery payment type")
    private DeliveryPaymentTypes deliveryPaymentType;

    @Schema(description = "delivery price type")
    private DeliveryPriceTypes deliveryPriceType;

    @Schema(description = "price")
    private BigDecimal price;

    @Schema(description = "customer price")
    private BigDecimal factCustomerPrice;

    @Schema(description = "seller price")
    private BigDecimal factSellerPrice;

    @Schema(description = "address")
    private AddressDto address;

    @Schema(description = "recipient")
    private PersonFullDto recipient;

    @Schema(description = "annotation")
    private String annotation;

    @Schema(description = "track code")
    private String trackCode;

    @Schema(description = "delivery date")
    private LocalDate deliveryDate;

    @Schema(description = "delivery time in")
    private LocalTime timeIn;

    @Schema(description = "delivery time out")
    private LocalTime timeOut;
}
