package com.afa.core.dto.products;

import com.afa.core.dto.BasePagedFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter extends BasePagedFilter {

    @Schema(description = "наименование, context", example = "LS-107")
    private String nameContext;

    @Schema(description = "sku", example = "LS-107")
    private String sku;

    @Schema(description = "long name")
    private String longName;

    @Schema(description = "short name")
    private String shortName;
}
