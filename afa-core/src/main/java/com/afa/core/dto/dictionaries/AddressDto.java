package com.afa.core.dto.dictionaries;

import com.afa.core.enums.AddressTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "address type")
    private AddressTypes type;

    @Schema(description = "country")
    private CountryDto country;

    @Schema(description = "city code")
    private String cityCode;

    @Schema(description = "city")
    private String city;

    @Schema(description = "delivery point code")
    private String deliperyPointCode;

    @Schema(description = "post code")
    private String postCode;

    @Schema(description = "street")
    private String street;

    @Schema(description = "house")
    private String house;

    @Schema(description = "flat")
    private String flat;

    @Schema(description = "address line")
    private String addressLine;
}
