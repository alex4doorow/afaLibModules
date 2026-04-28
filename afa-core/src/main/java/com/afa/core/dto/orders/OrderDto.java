package com.afa.core.dto.orders;

import com.afa.core.dto.customers.CustomerDto;
import com.afa.core.dto.dictionaries.OrderStatusTypeDto;
import com.afa.core.dto.persons.PersonShortDto;
import com.afa.core.dto.products.ProductCategoryDto;
import com.afa.core.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.SimplifyBooleanReturns", "PMD.CyclomaticComplexity", "PMD.TooManyFields"})
public class OrderDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "order num")
    private Long orderNum;

    @Schema(name = "order_date")
    private LocalDate orderDate;

    @Schema(name = "customer info")
    private CustomerDto customer;

    @Schema(name = "type", example = "ORDER")
    private OrderTypes type;

    @Schema(description = "source type", example = "CALL")
    private OrderSourceTypes sourceType;

    @Schema(description = "advert type", example = "ADVERT")
    private OrderAdvertTypes advertType;

    @Schema(description = "payment type", example = "PREPAYMENT")
    private OrderPaymentTypes paymentType;

    @Schema(description = "store")
    private StoreTypes store;

    @Schema(description = "product category")
    private ProductCategoryDto productCategory;

    @Schema(description = "delivery")
    private OrderDeliveryDto delivery;

    @Schema(description = "amounts")
    private Map<AmountTypes, BigDecimal> amounts;

    @Schema(description = "status")
    private OrderStatusTypeDto status;

    @Schema(description = "items")
    private Set<OrderItemDto> items;

    @Schema(description = "status history")
    private Set<OrderStatusHistoryDto> statusHistory;

    @Schema(description = "annotation")
    private String annotation;

    @Schema(description = "автор")
    private PersonShortDto userAdded;

    @Schema(description = "создано", example = "2024-06-16T07:42:45Z")
    private Instant dateAdded;

    @Schema(description = "presentation status")
    private OrderPresentationStatusDto presentation;

    @JsonIgnore
    public boolean isPrepayment() {
        if (paymentType == OrderPaymentTypes.PREPAYMENT || paymentType == OrderPaymentTypes.CARD_PAY) {
            return true;
        } else {
            return false;
        }
    }

    public String getViewNum() {
        final String result = String.valueOf(this.orderNum);
        /*
        if (getExternalCrms() != null && getExternalCrms().size() > 0) {
            if (this.getAdvertType() == OrderAdvertTypes.OZON) {
                String ozonMarketNo = "";
                for (OrderExternalCrm externalCrm : getExternalCrms()) {
                    if (externalCrm.getCrm() == CrmTypes.OZON) {
                        ozonMarketNo = String.valueOf(externalCrm.getParentCode());
                    }
                }
                result += " (" + ozonMarketNo + ")";
                return result;

            } else if (this.getAdvertType() == OrderAdvertTypes.YANDEX_MARKET) {
                String openCartNo = "";
                String yandexMarketNo = "";
                for (OrderExternalCrm externalCrm : getExternalCrms()) {
                    if (externalCrm.getCrm() == CrmTypes.OPENCART) {
                        openCartNo = String.valueOf(externalCrm.getParentId());
                    }
                    if (externalCrm.getCrm() == CrmTypes.YANDEX_MARKET) {
                        yandexMarketNo = String.valueOf(externalCrm.getParentId());
                    }
                }
                result += " (" + yandexMarketNo + " / " + openCartNo + ")";
                return result;
            }
            for (OrderExternalCrm externalCrm : getExternalCrms()) {
                if (externalCrm.getCrm() == CrmTypes.OPENCART) {
                    result += " (" + externalCrm.getParentId() + ")";
                    break;
                }
            }
            //Просмотр данных по заказу #10161 (197) от 01.03.2021 г.
        }

        */
       return result;
    }

    public String getViewMarketNum() {
        /*
        if (getExternalCrms() != null && getExternalCrms().size() > 0) {
            if (this.getAdvertType() == OrderAdvertTypes.OZON) {
                for (OrderExternalCrm externalCrm : getExternalCrms()) {
                    if (externalCrm.getCrm() == CrmTypes.OZON) {
                        return String.valueOf(externalCrm.getParentCode());
                    }
                }
            } else if (this.getAdvertType() == OrderAdvertTypes.YANDEX_MARKET) {
                String openCartNo = "";
                String yandexMarketNo = "";
                for (OrderExternalCrm externalCrm : getExternalCrms()) {
                    if (externalCrm.getCrm() == CrmTypes.OPENCART) {
                        openCartNo = String.valueOf(externalCrm.getParentId());
                    } else if (externalCrm.getCrm() == CrmTypes.YANDEX_MARKET) {
                        yandexMarketNo = String.valueOf(externalCrm.getParentId());
                    }
                }
                return yandexMarketNo + " / " + openCartNo;
            }
        }
        */
        return "";
    }

    public String getBarcodeNumber() {
        return "";
        //return DateHelper.formatDate(this.getOrderDate(), "yyMMdd") + StringUtils.leftPad(String.valueOf(this.getNo()), 2, '0');
    }
}
