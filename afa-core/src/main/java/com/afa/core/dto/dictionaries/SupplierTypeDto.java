package com.afa.core.dto.dictionaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SupplierTypeDto {

    @Schema(description = "code", example = "SITITEK")
    private String code;

    @Schema(description = "annotation", example = "СИТИТЕК")
    private String annotation;
}
