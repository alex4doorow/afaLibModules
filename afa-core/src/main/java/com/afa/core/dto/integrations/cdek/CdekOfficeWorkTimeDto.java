package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CdekOfficeWorkTimeDto {
    private Integer day;
    private String time;
}
