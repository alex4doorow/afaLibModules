package com.afa.core.dto.integrations.union;

import com.afa.core.dto.BaseResponse;
import com.afa.core.dto.customers.CustomerDto;
import com.afa.core.dto.orders.OrderDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDataUnionResponse extends BaseResponse {

    private final CustomerDto customer;
    private final List<OrderDto> orders;

    public CustomerDataUnionResponse(
            final CustomerDto customer,
            final List<OrderDto> orders) {
        super();
        this.customer = customer;
        this.orders = orders;
    }
}