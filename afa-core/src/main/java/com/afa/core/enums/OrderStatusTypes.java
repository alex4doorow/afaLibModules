package com.afa.core.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
select * from oc_order_status where language_id = 2
		1 добавлен
		2 процесс оплаты
		17 передан в CRM
		19 подтвержден
		15 оплачен
		3 отправлен
		20 прибыл
		18 получен
		5 завершен
		16 аннулирован
		12 возвращен
		11 возврат получен	
*/
@Getter
@AllArgsConstructor
public enum OrderStatusTypes {

	UNKNOWN(0, "неопределен", "", 0),
	BID(1, "заявка", "info", 1), // margin = 0, postpay = 0
    PROCESSING(21, "подтверждение", "info", 2), // margin = 0, postpay = 0
	UNPAID(22, "оформлен, не оплачен", "info", 3), // margin = 0, postpay = 0
	APPROVED(2, "подтвержден", "", 4),	// margin > 0, postpay > 0
	PAY_WAITING(3, "ожидаем оплату", "warning", 5), // margin = 0, postpay = ?
	PAY_ON(4, "оплата поступила", "warning", 6), // margin > 0, postpay = ?
	DELIVERING(5, "доставляется", "", 7), // margin > 0, postpay > 0
	READY_GIVE_AWAY(7, "прибыл", "", 8), // margin > 0, postpay > 0
	READY_GIVE_AWAY_TROUBLE(12, "заканчивается срок хранения", "danger", 9), // margin > 0, postpay > 0
	DELIVERED(10, "получен", "", 10),
	DOC_NOT_EXIST(11, "нет ТОРГ-12", "", 11), // margin > 0, postpay = 0
	FINISHED(8, "завершен", "success", 12), // margin > 0, postpay = 0
	REDELIVERY(9, "отказ от вручения", "secondary", 13), // margin = 0, postpay > 0
	CANCELED(13, "отменен", "danger", 14), // margin = 0, postpay = 0
	REDELIVERY_FINISHED(15, "возврат получен", "danger", 15), // --
	LOST(16, "утерян", "lost", 16); // margin = 0, postpay = 0

	private final int id;
	private final String annotation;
	private final String view;
    private final int sortKey;

    public String getCode() {
        return name();
    }

    @JsonIgnore
    public boolean isConfirmationAllowed(final OrderStatusTypes request) {
        return isConfirmationAllowed(this, request);
    }

    @JsonIgnore
    @SuppressWarnings("PMD.SimplifyBooleanReturns")
    public static boolean isConfirmationAllowed(final OrderStatusTypes current, final OrderStatusTypes request) {
        if (request != APPROVED) {
            return false;
        }
        if (current == BID || current == PROCESSING) {
            return true;
        }
        return false;
    }
}
