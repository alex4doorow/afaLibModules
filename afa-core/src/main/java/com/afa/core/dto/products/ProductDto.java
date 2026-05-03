package com.afa.core.dto.products;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "product info")
public class ProductDto {

    @Schema(description = "id")
    private Long id;

    @Schema(name = "sku")
    private String sku;

    @Schema(name = "short name")
    private String shortName;

    @Schema(name = "long name")
    private String longName;

    @Schema(name = "quantity")
    private Integer quantity;

    @Schema(name = "price")
    private BigDecimal price;

    @Schema(name = "composite")
    private Boolean composite;

    @Schema(name = "deactivated")
    private Boolean deactivated;

    @Schema(name = "stock")
    private StockSupplierProductDto stock;

    public String getViewName() {
        final int MAX_VIEW_LENGTH = 139;
        final String result;
        if (StringUtils.isNotEmpty(this.sku)) {
            result = "[" + StringUtils.upperCase(this.sku) + "] " + this.shortName;
        } else {
            result = this.shortName;
        }
        final int index = Math.min(result.length(), MAX_VIEW_LENGTH);
        if (index < result.length()) {
            return result.substring(0, index) + "...";
        } else {
            return result.substring(0, index);
        }
    }

}
