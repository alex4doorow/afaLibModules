package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderSourceTypes {
		
	UNKNOWN("неопределен"),
	CALL("звонок"),
	CHAT("чат"),
	EMAIL("письмо"),
	LID("лид"),
	FAST_LID("быстрый заказ"),
	CALL_BACK("обратный звонок"),
	TENDER("тендер");
	
    private final String annotation;

    public String getCode() {
        return name();
    }

}
