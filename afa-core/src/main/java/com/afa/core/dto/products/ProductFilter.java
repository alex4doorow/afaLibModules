package com.afa.core.dto.products;

import com.afa.core.dto.BasePagedFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings({"PMD.CommentRequired", "PMD.TooManyFields"})
public class ProductFilter extends BasePagedFilter {

    @Schema(description = "наименование, context", example = "LS-107")
    private String nameContext;

    private String sku;
    private String longName;
    private String shortName;
}
