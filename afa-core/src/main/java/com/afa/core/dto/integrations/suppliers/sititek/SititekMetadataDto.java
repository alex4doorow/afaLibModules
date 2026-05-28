package com.afa.core.dto.integrations.suppliers.sititek;

import com.afa.core.dto.products.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SititekMetadataDto {
    private SititekProductDto priceProduct;
    private ProductDto product;
}
