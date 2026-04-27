package com.afa.core.dto.employee;

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
public class EmployeeSettingsDto {

    private CustomerConditionsDto customers;
    private OrderConditionsDto orders;

}

/*
aProductSalesReportForm	period.start	06.02.2023
aProductSalesReportForm	period.end	12.02.2023
orderConditionsForm	reportPeriodType	4
orderConditionsForm	periodExist	1
orderConditionsForm	reportPeriodMonth	8
orderConditionsForm	reportPeriodYear	2021
orderConditionsForm	no
orderConditionsForm	trackCode
orderConditionsForm	deliveryAddress
orderConditionsForm	product	0
orderConditionsForm	customerConditions.person.phoneNumber
orderConditionsForm	customerConditions.person.email
orderConditionsForm	customerConditions.person.lastName
orderConditionsForm	customerConditions.company.inn
orderConditionsForm	customerConditions.company.shortName
orderConditionsForm	period.start	01.08.2021
orderConditionsForm	period.end	31.08.2021
orderConditionsForm	statuses
orderConditionsForm	orderTypes
orderConditionsForm	deliveryTypes
orderConditionsForm	customerTypes
orderConditionsForm	paymentTypes
orderConditionsForm	advertTypes
ozonProductConditionsForm	ozonSellerExist	-1
ozonProductConditionsForm	supplierStockExist	-1
ozonProductConditionsForm	suppliers
productForm	product.id	-1
productSalesReportByQueryForm	period.start	01.12.2023
productSalesReportByQueryForm	period.end	31.12.2023
productSalesReportByQueryForm	reportQueryName	5
salesFunnelReportForm	reportPeriodType	4
salesFunnelReportForm	reportPeriodMonth	5
salesFunnelReportForm	reportPeriodQuarter	4
salesFunnelReportForm	reportPeriodHalfYear	2
salesFunnelReportForm	reportPeriodYear	2023
salesFunnelReportForm	period.start	01.05.2023
salesFunnelReportForm	period.end	31.05.2023
stockForm	supplier.id	6
stockForm	productCategory.id	0
ymProductConditionsForm	yandexSellerExist	1
ymProductConditionsForm	supplierStockExist	-1
ymProductConditionsForm	suppliers	2
*/