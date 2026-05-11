package com.afa.core.dto.integrations.cdek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CdekCityFilter {

    private String countryCode2;
    private String cityNameContext;

}
