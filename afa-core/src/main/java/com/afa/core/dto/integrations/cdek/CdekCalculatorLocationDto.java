package com.afa.core.dto.integrations.cdek;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CdekCalculatorLocationDto {

    @JsonProperty("country_code")
    private String countryCode;

    /**
     * Код населенного пункта СДЭК (метод "Список населенных пунктов")
     * <a href="https://api.edu.cdek.ru/v2/location/cities">...</a>
     */
	private Integer code;

    private String city;

    private String address;

	private String region;

	@JsonProperty("region_code")
	private String regionCode;

    @JsonProperty("contragent_type")
    private String contragentType;

	private BigDecimal longitude;

	private BigDecimal latitude;
}	
