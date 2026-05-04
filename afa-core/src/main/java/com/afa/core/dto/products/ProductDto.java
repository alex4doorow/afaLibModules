package com.afa.core.dto.products;

import com.afa.core.enums.SupplierTypes;
import com.afa.core.enums.WeightClasses;
import com.afa.core.utils.NumericHelper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "product info")
@SuppressWarnings({"PMD.AvoidDuplicateLiterals", "PMD.CyclomaticComplexity", "PMD.CognitiveComplexity", "PMD.AvoidLiteralsInIfCondition"})
public class ProductDto {

    @Schema(description = "id")
    private Long id;

    @Schema(name = "sku")
    private String sku;

    @Schema(name = "short name")
    private String shortName;

    @Schema(name = "long name")
    private String longName;

    @Schema(name = "market quantity")
    private Integer quantity;

    @Schema(name = "price")
    private BigDecimal price;

    @Schema(name = "composite")
    private boolean composite;

    private BigDecimal weight;

    private WeightClasses weightClass;

    @Schema(name = "stock")
    private StockSupplierProductDto stock;

    private Integer sortKey;

    @Schema(name = "deactivated")
    private Boolean deactivated;

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

    public int getCompositeStockQuantity() {
        if (this.isComposite()) {
            return -1;
        } else {
            return this.getStock().getQuantity();
        }
    }

    public String getViewStockQuantityText() {


        final String supplierAnnotation;
        if (this.getCompositeStockQuantity() >= 1) {
            supplierAnnotation = "";
        } else {
            supplierAnnotation = ", уточнить наличие";
        }

        final String weightText;
        if (this.getWeight().compareTo(BigDecimal.ONE) < 0) {
            weightText = "";
        } else if (this.getWeightClass() == WeightClasses.KILOGRAM) {
            weightText = ", вес " + NumericHelper.formatNumber(this.getWeight(), "#,##0") + " кг";
        } else {
            final BigDecimal kgWeight = this.getWeight().divide(NumericHelper.ONE_THOUSAND, 3,
                    RoundingMode.HALF_UP);
            weightText = ", вес " + NumericHelper.formatNumber(kgWeight, "#,##0.###") + " кг";
        }

        if (SupplierTypes.SITITEK.getCode().equals(this.getStock().getSupplier().getCode())) {
            return "На складе: " + this.getCompositeStockQuantity() + " (всего: " + this.getQuantity() + ", поставщик " + this.getStock().getSupplier().getAnnotation() + ": " + this.getStock().getSupplierQuantity() + weightText + ")";
        } else {
            if (this.getQuantity() <= 0) {
                return "На складе: " + this.getCompositeStockQuantity() + " (поставщик " + this.getStock().getSupplier().getAnnotation() + ", на сайте: \"нет в наличии\")";
            } else {
                return "На складе: " + this.getCompositeStockQuantity() + " (поставщик " + this.getStock().getSupplier().getAnnotation() + ", на сайте: " + this.getQuantity() + supplierAnnotation + weightText + ")";
            }
        }
    }

    public String getViewStockQuantityClass() {
        if (this.getId() <= 0) {
            return "light";
        } else if (this.getStock().getSupplier() == null) {
            return "danger";
        } else if (SupplierTypes.SITITEK.getCode().equals(this.getStock().getSupplier().getCode())) {
            if (this.getCompositeStockQuantity() <= 0 && this.getStock().getSupplierQuantity() <= 0) {
                return "danger";
            } else if (this.getCompositeStockQuantity() > 0 && this.getStock().getSupplierQuantity() <= 0) {
                return "warning";
            } else if (this.getCompositeStockQuantity() <= 0 && this.getStock().getSupplierQuantity() > 0) {
                return "warning";
            } else {
                return "light";
            }
        } else {
            if (this.getCompositeStockQuantity() <= 0 && this.getQuantity() <= 0) {
                return "danger";
            } else if (this.getQuantity() <= 0) {
                return "warning";
            } else if (this.getCompositeStockQuantity() > 0) {
                return "light";
            } else {
                return "warning";
            }
        }
    }
}
