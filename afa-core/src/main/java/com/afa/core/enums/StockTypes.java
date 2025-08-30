package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockTypes {

    MAIN("основной");

    private final String annotation;

    public String getCode() {
        return name();
    }
}
