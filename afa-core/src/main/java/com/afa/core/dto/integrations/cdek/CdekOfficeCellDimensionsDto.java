package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CdekOfficeCellDimensionsDto {
    private Integer width;
    private Integer height;
    private Integer depth;
}
