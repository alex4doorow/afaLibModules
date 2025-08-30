package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrmTypes {

    NONE("нет"),
    OPENCART("Админка сайта"),
    EMAIL("Быстрй заказ"),
    CDEK("СДЭК Маркет"),
    YANDEX_MARKET("Яндекс Маркет"),
    OZON("ОЗОН Маркет");

    private final String name;

    public String getCode() {
        return name();
    }

    /**
     * Лид, с поведением как у ручного или ручной
     * @return
     */
    public boolean isSimple() {
        if (this == CrmTypes.NONE || this == CrmTypes.EMAIL || this == CrmTypes.CDEK) {
            return true;
        } else {
            return false;
        }
    }
}
