package com.afa.core.dto.employee;

import com.afa.core.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeSettingsResponse extends BaseResponse {

    private final EmployeeSettingsDto settings;

    public EmployeeSettingsResponse(final EmployeeSettingsDto settings) {
        super();
        this.settings = settings;
    }
}