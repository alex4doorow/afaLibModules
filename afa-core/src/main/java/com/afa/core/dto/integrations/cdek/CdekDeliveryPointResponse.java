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
public class CdekDeliveryPointResponse extends BaseResponse {

    @Schema(description = "list with all data")
    private final List<CdekDeliveryPointDto> items;

    public CdekDeliveryPointResponse(
            final List<CdekDeliveryPointDto> items) {
        super();
        this.items = items;
    }
}
