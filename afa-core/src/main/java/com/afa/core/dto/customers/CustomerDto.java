package com.afa.core.dto.customers;

import com.afa.core.dto.companies.CompanyDto;
import com.afa.core.dto.dictionaries.CountryDto;
import com.afa.core.dto.people.PersonFullDto;
import com.afa.core.dto.people.PersonShortDto;
import com.afa.core.enums.AddressTypes;
import com.afa.core.enums.ContactTypes;
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
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.SimplifyBooleanReturns", "PMD.CyclomaticComplexity", "PMD.TooManyFields"})
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

    public CountryDto getCountry() {
        if (company != null) {
            return company.getCountry();
        } else if (person != null) {
            return person.getCountry();
        } else {
            return null;
        }
    }

    public String getShortName() {
        if ((company != null) && (type == CustomerTypes.COMPANY || type == CustomerTypes.FOREIGNER_COMPANY)) {
            return company.getShortName();
        } else if (person != null) {
            return person.getShortName();
        } else {
            return "";
        }
    }

    public String getLongName() {
        if ((company != null) && (type == CustomerTypes.COMPANY || type == CustomerTypes.FOREIGNER_COMPANY)) {
            return company.getLongName();
        } else if (person != null) {
            return person.getFullName();
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

    public String getFullPhoneNumber() {
        return getCountry() == null
                ? getPhoneNumber()
                : getCountry().getIsdCode() + " " + getPhoneNumber();
    }

    public String getEmail() {
        if (company != null) {
            return company.getEmail();
        } else if (person != null) {
            return person.getEmail();
        } else {
            return "";
        }
    }

    public String getViewLongNameWithContactInfo() {
        if (company != null) {
            final String viewLongName = company.getViewLongName();
            final String contact = getMainContact().getPerson().getFullName() + " " + getMainContact().getPerson().getEmail();
            return viewLongName.trim() + ", " + contact;
        } else if (person != null) {
            return person.getFullName() + ", " + getFullPhoneNumber();
        }
        return "";
    }

    public CustomerContactDto getMainContact() {
        if (contacts == null || contacts.isEmpty()) {
            return null;
        }
        return contacts.stream()
                .filter(c -> c.getType() == ContactTypes.MAIN)
                .findFirst()
                .orElse(null);

    }

    public CustomerAddressDto getMainAddress() {
        if (addresses == null || addresses.isEmpty()) {
            return null;
        }
        return addresses.stream()
                .filter(a -> a.getAddress().getType() == AddressTypes.MAIN)
                .findFirst()
                .orElse(null);
    }
}
