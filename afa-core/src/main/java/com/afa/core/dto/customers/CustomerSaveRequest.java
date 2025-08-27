package com.afa.core.dto.customers;

import com.afa.core.dto.companies.CompanySaveRequest;
import com.afa.core.dto.persons.PersonSaveRequest;
import com.afa.core.enums.CustomerTypes;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Customer")
public class CustomerSaveRequest {

    @NotNull
    @Schema(description = "customer type")
    private CustomerTypes type;

    @Schema(description = "company")
    private CompanySaveRequest company;

    @Schema(description = "person")
    private PersonSaveRequest person;

    @NotNull
    @Schema(description = "country id")
    private UUID countryId;

    @Valid
    @NotNull
    @Size(max = 10)
    @Schema(description = "customer contacts")
    private Set<CustomerContactSaveRequest> contacts;

    @Valid
    @NotNull
    @Size(max = 2)
    @Schema(description = "customer addresses")
    private Set<CustomerAddressSaveRequest> addresses;
}
