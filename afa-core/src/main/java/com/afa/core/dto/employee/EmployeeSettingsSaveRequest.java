package com.afa.core.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Customer")
public class EmployeeSettingsSaveRequest {

    private final EmployeeSettingsDto settings;

}
