package com.afa.core.dto.integrations.cdek;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CdekCityResponse extends BaseResponse {

    @Schema(description = "list with all data")
    private final List<CdekCityDto> items;

    public CdekCityResponse(
            final List<CdekCityDto> items) {
        super();
        this.items = items;
    }
}
