package com.afa.core.dto.dictionaries;

import com.afa.core.enums.AddressTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Address")
public class AddressSaveRequest {

    @NotNull
    @Schema(description = "address type")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private AddressTypes type;

    @NotNull
    @Schema(description = "country id")
    private UUID countryId;

    @Size(min = 6, max = 6)
    @Schema(description = "post code")
    private String postCode;

    @Schema(description = "street")
    private String street;

    @Schema(description = "house")
    private String house;

    @Schema(description = "flat")
    private String flat;

    @NotBlank
    @Size(min = 1, max = 250)
    @Schema(description = "address line")
    private String addressLine;
}
