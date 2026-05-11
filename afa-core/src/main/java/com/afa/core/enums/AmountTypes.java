package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AmountTypes {
		
	UNKNOWN(0, "не определена"),
    TOTAL(6, "итоговая сумма за товар"),
	TOTAL_WITH_DELIVERY(1, "итоговая сумма к оплате клиенту (равна итоговой детализации + стоимости доставки)"),
	BILL(2, "сумма чека (наш доход)"),
	SUPPLIER(3, "стоимость закупки"),
	MARGIN(4, "прибыль за вычетом налогов (amount_bill - amount_supplier)"),
	POSTPAY(5, "стоимость постоплаты"),
    TOTAL_WEIGHT_GRAM(9, "weight gram"),
    TOTAL_LENGTH_CM(9, "length cm"),
    TOTAL_HEIGHT_CM(9, "height cm"),
    TOTAL_WIDTH_CM(9, "width cm"),

	// только для отчетов
	DELIVERY(7, "стоимость доставки"),
	CASH_ON_DELIVERY(8, "наложенный платеж"),

	COUNT_VISITS(102, "число сеансов за период"),
	COUNT_UNIQUE_VISITORS(107, "число уникальных посетителей за период"),
	COUNT_NEW_VISITORS(111, "число новых посетителей за период"),	
	COUNT_REAL_ORDERS(106, "число реальных заказов за период"),

	CONVERSION_APPROVED(127, "конверсия (заказы/сеансы)"), 
	CONVERSION_BID(128, "конверсия (заявки/сеансы)"),

	POSTPAY_CDEK(108, "стоимость постоплаты СДЭК"),
	POSTPAY_POST(109, "стоимость постоплаты почта"),
	POSTPAY_COMPANY(110, "стоимость постоплаты организаций"),
	POSTPAY_YANDEX_MARKET(131, "стоимость постоплаты \"Яндекс.Маркет\""),
	POSTPAY_OZON_MARKET(112, "стоимость постоплаты \"OZON\""),
	POSTPAY_YANDEX_GO(114, "стоимость постоплаты \"YANDEX GO\""),

    ADVERT_BUDGET(101, "рекламный бюджет за месяц"),
	ADVERT_WEEK_BUDGET(132, "рекламный бюджет за неделю"),
		
	// total amounts
	TOTAL_SUPPLIER(121, "суммарный опт"),
	TOTAL_BILL(122, "суммарная розница");	
		
	private final int id;
    private final String annotation;

    public String getCode() {
        return name();
    }

}
