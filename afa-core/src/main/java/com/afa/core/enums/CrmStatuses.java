package com.afa.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrmStatuses {

    NONE("нет обработки"),
    SUCCESS("успешно"),
    FAIL("ошибки");

    private final String name;

    public String getCode() {
        return name();
    }

}
