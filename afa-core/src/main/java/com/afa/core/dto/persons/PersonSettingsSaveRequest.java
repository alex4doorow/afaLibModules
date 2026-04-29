package com.afa.core.dto.persons;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Customer")
public class PersonSettingsSaveRequest {

    private final PersonSettingsDto settings;

}
