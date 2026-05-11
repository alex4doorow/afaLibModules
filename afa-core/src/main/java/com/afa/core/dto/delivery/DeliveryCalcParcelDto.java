package com.afa.core.dto.delivery;

import com.afa.core.dto.dictionaries.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("PMD.TooManyFields")
public class DeliveryCalcParcelDto {

    private BigDecimal postpayAmount;
    private BigDecimal deliveryAmount;

    private BigDecimal deliveryPrice;
    private BigDecimal deliveryInsurance;
    private BigDecimal deliveryPostpayFee;

    /**
     * стоимость доставки (прайс + все комиссии)
     */
    private BigDecimal deliveryFullPrice;
    /**
     * сколько берем с клиента за доставку
     */
    private BigDecimal deliveryCustomerSummary;
    /**
     * сколько берет c нас сдэк за доставку и инкассацию
     */
    private BigDecimal deliverySellerSummary;

    @Builder.Default
    private Integer deliveryPeriodMin = 0;

    @Builder.Default
    private Integer deliveryPeriodMax = 0;

    private String termText;
    private String to;
    private String parcelType;
    private String weightText;
    private String localTimeText;
    private String errorText;

    private Set<AddressDto> addresses;

    public static DeliveryCalcParcelDto createEmpty() {
        return new DeliveryCalcParcelDto();
    }

}
