package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum SupplierTypes {
		
	SITITEK( "СИТИТЕК"),
	Z1_VEK( "ЭКОСНАЙПЕР"),
	DADJET( "ДАДЖЕТ"),
	CAMPING_2000( "КЕМПИНГ 2000"),
	T4L( "ТЕХНОЛОГИИ ДЛЯ ЖИЗНИ"),
	LADIA( "ЛАДЬЯ"),
	ELANG( "ЭЛАНГ"),
	TELEMETRIKA( "ТЕЛЕМЕТРИКА"),
	UST( "ЮСТ"),
	MIGOWATT("МИГОВАТТ"),
	SLEDOPYT("СЛЕДОПЫТ"),
	PYROHOUSE("ПИРОХАУС"),
	HOONT("HOONT"),
	CARKU("CARKU"),
	TORNADO("ТОРНАДО"),
	RUSONAR("ПРАКТИК"),
	SLEDOPYT_YANDEX_MARKET_FISHING("СЛЕДОПЫТ ЯМ-РЫБАЛКА");
				
    private final String annotation;

    public String getCode() {
        return name();
    }
}
