package com.afa.core.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
@SuppressWarnings({"PMD.UnnecessaryFullyQualifiedName", "PMD.AvoidDuplicateLiterals", "PMD.SimplifyBooleanReturns"})
public enum DeliveryTypes {

    UNKNOWN(0, "Неопределено", "неопределено"),
    CDEK_PVZ_TYPICAL(101, "CDEK", "СДЭК, ПВЗ"),
    CDEK_PVZ_ECONOMY(102, "CDEK", "СДЭК, ЭКОНОМ ПВЗ"),
    CDEK_COURIER(103, "CDEK", "СДЭК, курьер"),
    CDEK_COURIER_ECONOMY(104, "CDEK", "СДЭК, ЭКОНОМ курьер"),
    DELLIN(201, "ТК Деловые Линии", "Деловые Линии"),
    COURIER_MOSCOW_TYPICAL(301, "МОСКВА курьер 1-2 дня", "курьер, 1-2 дня"),
    COURIER_MOSCOW_FAST(302, "МОСКВА курьер, сегодня", "курьер, сегодня"),
    COURIER_MO_TYPICAL(303, "МО курьер, 1-2 дня", "МО, курьер"),
    POST_TYPICAL(401, "ПОЧТА РОССИИ", "ПОЧТА, обычное"),
    POST_I_CLASS(402, "ПОЧТА РОССИИ", "ПОЧТА, 1-й класс"),
    POST_EMS(405, "ПОЧТА EMS", "ПОЧТА, EMS"),
    PICKUP(403, "самовывоз, сегодня", "самовывоз"),
    YANDEX_MARKET_FBS(501, "YANDEX MARKET", "до склада Яндекс-Маркет"),
    OZON_FBS(701, "OZON", "до склада OZON"),
    YANDEX_GO(601, "YANDEX GO", "Яндекс-Логистика");

    private final int id;
    private final String category;
    private final String annotation;

    public String getCode() {
        return name();
    }

    @JsonIgnore
    public boolean isCdek() {
        if (this == DeliveryTypes.PICKUP
                || this == DeliveryTypes.CDEK_PVZ_TYPICAL
                || this == DeliveryTypes.CDEK_PVZ_ECONOMY
                || this == DeliveryTypes.CDEK_COURIER
                || this == DeliveryTypes.CDEK_COURIER_ECONOMY) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    public boolean isCdekPvz() {
        if (this == DeliveryTypes.CDEK_PVZ_TYPICAL
                || this == DeliveryTypes.CDEK_PVZ_ECONOMY
                || this == DeliveryTypes.PICKUP) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    public boolean isPost() {
        if (this == DeliveryTypes.POST_TYPICAL
                || this == DeliveryTypes.POST_I_CLASS
                || this == DeliveryTypes.POST_EMS) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    public boolean isCourier() {
        if (this == DeliveryTypes.COURIER_MOSCOW_TYPICAL
                || this == DeliveryTypes.COURIER_MOSCOW_FAST
                || this == DeliveryTypes.COURIER_MO_TYPICAL) {
            return true;
        } else {
            return false;
        }
    }
}
