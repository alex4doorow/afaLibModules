package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryPaymentTypes {

    CUSTOMER("покупатель"),
    SELLER("продавец");

    private final String annotation;

    public String getCode() {
        return name();
    }
}
