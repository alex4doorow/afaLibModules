package com.afa.core.dto.persons;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonSettingsResponse extends BaseResponse {

    private final PersonSettingsDto settings;

    public PersonSettingsResponse(final PersonSettingsDto settings) {
        super();
        this.settings = settings;
    }
}