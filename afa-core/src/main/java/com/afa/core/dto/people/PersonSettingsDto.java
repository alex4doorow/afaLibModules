package com.afa.core.dto.people;

import com.afa.core.dto.customers.CustomerConditionsDto;
import com.afa.core.dto.orders.OrderConditionsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSettingsDto {

    private CustomerConditionsDto customers;
    private OrderConditionsDto orders;

}
