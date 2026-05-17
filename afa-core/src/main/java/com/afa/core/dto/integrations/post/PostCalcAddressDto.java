package com.afa.core.dto.integrations.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCalcAddressDto {

    @JsonProperty("Индекс")
    private String index;

    @JsonProperty("Название")
    private String name;

    @JsonProperty("Адрес")
    private String address;
}