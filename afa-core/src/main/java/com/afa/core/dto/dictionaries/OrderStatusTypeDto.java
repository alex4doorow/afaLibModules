package com.afa.core.dto.dictionaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "delivery type info")
public class OrderStatusTypeDto {

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "code", example = "BID")
    private String code;

    @Schema(description = "view", example = "danger")
    private String view;

    @Schema(description = "annotation", example = "Заявка")
    private String annotation;

    @Schema(description = "sort key")
    private Integer sortKey;
}