package com.afa.core.dto.delivery;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Schema(description = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryCalcParcelAmountsResponse extends BaseResponse {

    private final DeliveryCalcParcelDto deliveryCalcParcel;

    public DeliveryCalcParcelAmountsResponse(final DeliveryCalcParcelDto deliveryCalcParcel) {
        super();
        this.deliveryCalcParcel = deliveryCalcParcel;
    }
}
