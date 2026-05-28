package com.afa.core.dto.integrations.suppliers.sititek;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SititekProductDto {
    private String sku;
    private String name;
    private BigDecimal supplierPrice1;
    private BigDecimal supplierPrice2;
    private BigDecimal supplierPrice3;
    private BigDecimal customerPrice;
    private Integer quantity;

    public SititekProductDto(final String sku, final String name) {
        this.sku = sku;
        this.name = name;
    }
}
/*
Остатки	Артикул	Наименование	Вес	Страна производства	Производитель	Гарантия	ОПТ2 (<20 т.р.)	ОПТ1 (20-40 т.р.)	ОПТ (>40 т.р.)	РРЦ

Аксессуары для вина
9	63153	Аэратор для вина "SITITEK Magic Decanter Aroma"	0,31	Гонконг	SITITEK	12	748	714	680	980
        2	70574	Камни для виски "WhiStone E" (6 камней)	0.2	РОССИЯ	SITITEK	1	495	473	450	650
        5	70575	Камни для виски "WhiStone M" со щипцами (12 камней)	0.37	РОССИЯ	SITITEK	1	847	809	770	1 090
        10	70677	Камни для виски "WhiStone S" с щипцами (9 камней)	0,3	РОССИЯ	SITITEK	1	759	725	690	980
        66	70149	Набор подарочный для вина "SITITEK Vinomax"	0.611	Гонконг	SITITEK	12	671	641	610	770
*/