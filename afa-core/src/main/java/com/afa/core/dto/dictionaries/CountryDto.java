package com.afa.core.dto.dictionaries;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Country")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto {

    @Schema(description = "id")
    private UUID id;

    @Schema(description = "short name")
    private String name;

    @Schema(description = "ISO code (2 digits)")
    private String isoCode2;

    @Schema(description = "ISO code (3 digits)")
    private String isoCode3;

    @Schema(description = "ISO code (prefix phone number)")
    private String isdCode;
}
