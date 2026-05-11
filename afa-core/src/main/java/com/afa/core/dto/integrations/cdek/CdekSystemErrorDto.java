package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CdekSystemErrorDto {
    private String code;
    @JsonAlias("additional_code")
    private String additionalCode;
    private String message;
}
