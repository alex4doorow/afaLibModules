package com.afa.core.dto.orders;

import com.afa.core.enums.DeliveryTypes;
import com.afa.core.enums.OrderPaymentTypes;
import com.afa.core.enums.OrderStatusTypes;
import com.afa.core.enums.OrderTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Order view status info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class OrderPresentationStatusDto {

    public final static String VIEW_STATUS_NONE = "";
    public final static String VIEW_STATUS_SUCCESS = "success";
    public final static String VIEW_STATUS_WARNING = "warning";
    public final static String VIEW_STATUS_DANGER = "danger";
    public final static String VIEW_STATUS_INFO = "info";
    public final static String VIEW_STATUS_SECONDARY = "secondary";
    public final static String VIEW_STATUS_LIGHT = "light";
    public final static String VIEW_STATUS_DARK = "dark";

    private String union;
    private String orderId;
    private String orderNo;
    private String orderDate;

    public OrderPresentationStatusDto() {
        this.union = VIEW_STATUS_LIGHT;
        this.orderId = VIEW_STATUS_LIGHT;
        this.orderNo = VIEW_STATUS_LIGHT;
        this.orderDate = VIEW_STATUS_LIGHT;
    }

    public static OrderPresentationStatusDto createOrderPresentationStatusDto(final OrderDto orderDto) {

        OrderPresentationStatusDto orderPresentationStatusDto = new OrderPresentationStatusDto();
        if (orderDto.getType() == OrderTypes.KP || orderDto.getType() == OrderTypes.CONSULTATION) {
            if (orderDto.getStatus().getCode().equals(OrderStatusTypes.CANCELED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto;
            } else {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_INFO);
                return orderPresentationStatusDto; // голубой
            }
        } else if (orderDto.getType() == OrderTypes.ORDER) {
            if (orderDto.getStatus().getCode().equals(OrderStatusTypes.BID.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.APPROVED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_MARKET_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.OZON_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                } else if (orderDto.getDelivery().getDeliveryType().isCdek()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                } else if (orderDto.getDelivery().getDeliveryType().isPost()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                } else if (orderDto.getDelivery().getDeliveryType().isCourier()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_WARNING);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_GO.name())) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_WARNING);
                    return orderPresentationStatusDto;
                }
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DOC_NOT_EXIST.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                orderPresentationStatusDto.setOrderId(VIEW_STATUS_DARK);
                orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DARK);
                orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DARK);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.FINISHED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_SUCCESS);
                return orderPresentationStatusDto; // зеленый
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.REDELIVERY.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto; // красный
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.CANCELED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto; // красный
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.LOST.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto; // красный
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.REDELIVERY_FINISHED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto; // красный
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DELIVERING.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                if (orderDto.getDelivery().getDeliveryType().isCdek()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().isPost()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().isCourier()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_WARNING);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_GO.name())) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_WARNING);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_MARKET_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.OZON_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                }
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.READY_GIVE_AWAY.name()) || orderDto.getStatus().getCode().equals(OrderStatusTypes.READY_GIVE_AWAY_TROUBLE.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                if (orderDto.getDelivery().getDeliveryType().isCdek()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().isPost()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_MARKET_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.OZON_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                }
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DELIVERED.name())) {
                if (orderDto.getDelivery().getDeliveryType().isPost() || orderDto.getDelivery().getDeliveryType().isCdek()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().isCourier()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.YANDEX_MARKET_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getDelivery().getDeliveryType().getCode().equals(DeliveryTypes.OZON_FBS.name())) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                }
            }
        } else if (orderDto.getType() == OrderTypes.BILL) {
            if (orderDto.getStatus().getCode().equals(OrderStatusTypes.BID.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_INFO);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.APPROVED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                if (orderDto.isPrepayment()) {
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                } else {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                }
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.PAY_WAITING.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.PAY_ON.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                if (orderDto.isPrepayment()) {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_WARNING);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                } else {
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                }
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DOC_NOT_EXIST.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                orderPresentationStatusDto.setOrderId(VIEW_STATUS_DARK);
                orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DARK);
                orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DARK);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.FINISHED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_SUCCESS);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.CANCELED.name())) {
                orderPresentationStatusDto.setUnion(VIEW_STATUS_DANGER);
                return orderPresentationStatusDto;
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DELIVERING.name())) {
                if (orderDto.isPrepayment()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                } else if (orderDto.getPaymentType() == OrderPaymentTypes.POSTPAY) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_DANGER);
                    return orderPresentationStatusDto;
                }
            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.READY_GIVE_AWAY.name())
                    || orderDto.getStatus().getCode().equals(OrderStatusTypes.READY_GIVE_AWAY_TROUBLE.name())) {
                if (orderDto.isPrepayment()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getPaymentType() == OrderPaymentTypes.POSTPAY) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                }

            } else if (orderDto.getStatus().getCode().equals(OrderStatusTypes.DELIVERED.name())) {
                if (orderDto.isPrepayment()) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    orderPresentationStatusDto.setOrderDate(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                } else if (orderDto.getPaymentType() == OrderPaymentTypes.POSTPAY) {
                    orderPresentationStatusDto.setUnion(VIEW_STATUS_LIGHT);
                    orderPresentationStatusDto.setOrderId(VIEW_STATUS_DANGER);
                    orderPresentationStatusDto.setOrderNo(VIEW_STATUS_SUCCESS);
                    return orderPresentationStatusDto;
                }
            }

        } else if (orderDto.getType() == OrderTypes.REFUND) {
            orderPresentationStatusDto.setUnion(VIEW_STATUS_SECONDARY);
            return orderPresentationStatusDto;

        } else if (orderDto.getType() == OrderTypes.REPAIR || orderDto.getType() == OrderTypes.CHANGE) {
            orderPresentationStatusDto.setUnion(VIEW_STATUS_SECONDARY);
            return orderPresentationStatusDto;

        } else if (orderDto.getType() == OrderTypes.GIFT) {
            orderPresentationStatusDto.setUnion(VIEW_STATUS_SECONDARY);
            return orderPresentationStatusDto;

        } else if (orderDto.getType() == OrderTypes.TEST_DIVE) {
            orderPresentationStatusDto.setUnion(VIEW_STATUS_SECONDARY);
            return orderPresentationStatusDto;
        }
        return orderPresentationStatusDto;
    }
}
