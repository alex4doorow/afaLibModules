package com.afa.core.dto.products;

import com.afa.core.enums.StockTypes;
import com.afa.core.enums.SupplierTypes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockSupplierProductDto {

    @Schema(name = "id")
    private Long id;

    @Schema(name = "stock")
    private StockTypes stock;

    @Schema(name = "supplier")
    private SupplierTypes supplier;

    @Schema(name = "supplier price")
    private BigDecimal supplierPrice;

    @Schema(name = "supplier quantity")
    private Integer supplierQuantity;
}
