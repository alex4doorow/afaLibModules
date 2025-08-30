package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderPaymentTypes {

	PREPAYMENT("предоплата"),
	POSTPAY("постоплата"),
	PAYMENT_COURIER("наличными курьеру"),
	CARD_PAY("банковской картой");

	private final String annotation;

    public String getCode() {
        return name();
    }
}
