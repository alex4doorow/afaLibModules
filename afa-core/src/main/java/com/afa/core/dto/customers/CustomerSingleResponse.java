package com.afa.core.dto.customers;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Schema(description = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSingleResponse extends BaseResponse {

    @Schema(description = "customer with all data")
    private final CustomerDto customer;

    public CustomerSingleResponse(final CustomerDto customer) {
        super();
        this.customer = customer;
    }
}