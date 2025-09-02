package com.afa.core.dto.companies;

import com.afa.core.dto.dictionaries.CountryDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "country")
    private CountryDto country;

    @Schema(description = "inn")
    private String inn;

    @Schema(description = "short name")
    private String shortName;

    @Schema(description = "long name")
    private String longName;

    @Schema(description = "phone_number")
    private String phoneNumber;

    @Schema(description = "email")
    private String email;

    public String getViewLongName() {
        String viewLongName = StringUtils.isNotEmpty(this.longName) ? longName : this.shortName;
        viewLongName = viewLongName.trim();
        if (StringUtils.isEmpty(this.inn)) {
            return viewLongName;
        } else {
            return "ИНН " + this.inn + " " + StringUtils.defaultString(viewLongName);
        }
    }


}
