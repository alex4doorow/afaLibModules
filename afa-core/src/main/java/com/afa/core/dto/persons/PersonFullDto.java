package com.afa.core.dto.persons;

import com.afa.core.dto.dictionaries.CountryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "person full info")
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.SimplifyBooleanReturns", "PMD.CyclomaticComplexity", "PMD.TooManyFields"})
public class PersonFullDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "country")
    private CountryDto country;

    @Schema(description = "first name", example = "Сергей")
    private String firstName;

    @Schema(description = "last name", example = "V")
    private String middleName;

    @Schema(description = "last name", example = "Туманов")
    private String lastName;

    @Schema(description = "phone number")
    private String phoneNumber;

    @Schema(description = "email")
    private String email;

    @Schema(description = "inn")
    private String inn;

    public String getFullName() {
        final String fn = StringUtils.isBlank(this.firstName) ? "" : this.firstName;
        final String mn = StringUtils.isBlank(this.middleName) ? "" : this.middleName;
        final String ln = StringUtils.isBlank(this.lastName) ? "" : this.lastName;
        if (StringUtils.isNotEmpty(fn) && StringUtils.isEmpty(mn) && StringUtils.isEmpty(ln)) {
            return fn;
        } else if (StringUtils.isNotEmpty(fn) && StringUtils.isEmpty(mn) && StringUtils.isNotEmpty(ln)) {
            return fn + " " + ln;
        } else if (StringUtils.isNotEmpty(fn) && StringUtils.isNotEmpty(mn) && StringUtils.isNotEmpty(ln)) {
            return fn + " " + mn + " " + ln;
        }  else if (StringUtils.isEmpty(fn) && StringUtils.isNotEmpty(ln)) {
            return ln;
        } else {
            return fn;
        }
    }

    public String getShortName() {
        final String fn = StringUtils.isBlank(this.firstName) ? "" : this.firstName.substring(0, 1).toUpperCase(Locale.getDefault()) + ".";
        final String mn = StringUtils.isBlank(this.middleName) ? "" : this.middleName.substring(0, 1).toUpperCase(Locale.getDefault()) + ".";
        final String ln = StringUtils.isBlank(this.lastName) ? "" : this.lastName;
        return ln + " " + fn + mn;
    }

    public String getFullPhoneNumber() {
        return getCountry() == null
                ? getPhoneNumber()
                : getCountry().getIsdCode() + " " + getPhoneNumber();
    }
}
