package com.afa.core.dto.customers;

import com.afa.core.dto.people.PersonSaveRequest;
import com.afa.core.enums.ContactTypes;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Customer contact")
public class CustomerContactSaveRequest {

    @NotNull
    @Schema(description = "contact type")
    private ContactTypes type;

    @NotNull
    @Schema(description = "person")
    private PersonSaveRequest person;

}
