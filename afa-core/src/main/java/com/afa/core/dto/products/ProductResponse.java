package com.afa.core.dto.products;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse extends BaseResponse {

    @Schema(description = "list with all data")
    private final List<ProductDto> items;

    public ProductResponse(
            final List<ProductDto> items) {
        super();
        this.items = items;
    }
}