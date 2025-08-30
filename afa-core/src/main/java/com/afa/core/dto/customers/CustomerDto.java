package com.afa.core.dto.customers;

import com.afa.core.dto.companies.CompanyDto;
import com.afa.core.dto.persons.PersonFullDto;
import com.afa.core.dto.persons.PersonShortDto;
import com.afa.core.enums.CustomerTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "customer type")
    private CustomerTypes type;

    @Schema(description = "company info")
    private CompanyDto company;

    @Schema(description = "person info")
    private PersonFullDto person;

    @Schema(description = "contacts")
    private Set<CustomerContactDto> contacts;

    @Schema(description = "addresses")
    private Set<CustomerAddressDto> addresses;

    @Schema(description = "автор")
    private PersonShortDto userAdded;

    @Schema(description = "создано", example = "2024-06-16T07:42:45Z")
    private Instant dateAdded;

    public String getShortName() {
        if ((company != null) && (type == CustomerTypes.COMPANY || type == CustomerTypes.FOREIGNER_COMPANY)) {
            return company.getShortName();
        } else if (person != null) {
            return person.getShortName();
        } else {
            return "";
        }
    }

    public String getInn() {
        if ((company != null) && (type == CustomerTypes.COMPANY || type == CustomerTypes.FOREIGNER_COMPANY)) {
            return company.getInn();
        } else if (person != null) {
            return person.getInn();
        } else {
            return "";
        }
    }

    public String getPhoneNumber() {
        if (company != null) {
            return company.getPhoneNumber();
        } else if (person != null) {
            return person.getPhoneNumber();
        } else {
            return "";
        }
    }
}
