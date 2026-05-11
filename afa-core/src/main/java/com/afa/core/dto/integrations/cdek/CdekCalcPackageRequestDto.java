package com.afa.core.dto.integrations.cdek;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CdekCalcPackageRequestDto {
    private Integer weight;
    private Integer length;
    private Integer width;
    private Integer height;
}
