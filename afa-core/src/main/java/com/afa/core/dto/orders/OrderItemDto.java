package com.afa.core.dto.orders;

import com.afa.core.dto.products.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order delivery info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class OrderItemDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "item num")
    private Integer itemNum;

    @Schema(description = "product")
    private ProductDto product;

    @Schema(description = "price")
    private BigDecimal price;

    @Schema(description = "price supplier")
    private BigDecimal supplierPrice;

    @Schema(description = "quantity")
    private Integer quantity;

    @Schema(description = "discount rate")
    private BigDecimal discountRate;

    @Schema(description = "amount")
    private BigDecimal amount;

    @Schema(description = "amount supplier")
    private BigDecimal supplierAmount;
}
