package com.afa.core.dto.dictionaries;

import com.afa.core.enums.DeliveryTypes;
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
public class DeliveryTypeDto {

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "code", example = "CDEK_PVZ_TYPICAL")
    private String code;

    @Schema(description = "category")
    private String category;

    @Schema(description = "annotation", example = "СДЭК, ПВЗ")
    private String annotation;

    public boolean isCdek() {
        if (this.getCode().equals(DeliveryTypes.PICKUP.name()) || this.getCode().equals(DeliveryTypes.CDEK_PVZ_TYPICAL.name())
                || this.getCode().equals(DeliveryTypes.CDEK_PVZ_ECONOMY.name()) || this.getCode().equals(DeliveryTypes.CDEK_COURIER.name())
                || this.getCode().equals(DeliveryTypes.CDEK_COURIER_ECONOMY.name())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCdekPvz() {
        if (this.getCode().equals(DeliveryTypes.CDEK_PVZ_TYPICAL.name()) || this.getCode().equals(DeliveryTypes.CDEK_PVZ_ECONOMY.name())
                || this.getCode().equals(DeliveryTypes.PICKUP.name())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPost() {
        if (this.getCode().equals(DeliveryTypes.POST_TYPICAL.name()) || this.getCode().equals(DeliveryTypes.POST_I_CLASS.name())
                || this.getCode().equals(DeliveryTypes.POST_EMS.name())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCourier() {
        if (this.getCode().equals(DeliveryTypes.COURIER_MOSCOW_TYPICAL.name()) || this.getCode().equals(DeliveryTypes.COURIER_MOSCOW_FAST.name())
                || this.getCode().equals(DeliveryTypes.COURIER_MO_TYPICAL.name())) {
            return true;
        } else {
            return false;
        }
    }
}
