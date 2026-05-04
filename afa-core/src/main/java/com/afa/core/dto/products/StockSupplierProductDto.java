package com.afa.core.dto.products;

import com.afa.core.dto.dictionaries.SupplierTypeDto;
import com.afa.core.enums.StockTypes;
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
    private SupplierTypeDto supplier;

    @Schema(name = "supplier price")
    private BigDecimal supplierPrice;

    @Schema(name = "supplier quantity")
    private Integer supplierQuantity;

    @Schema(name = "shop quantity")
    private Integer quantity = 0;
}
