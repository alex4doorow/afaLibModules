package com.afa.core.dto.orders;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "person save request")
public class OrderDeliveryRecipientSaveRequest {

    @Size(max = 64)
    @Schema(description = "first name", example = "Алексей")
    private String firstName;

    @Size(max = 32)
    @Schema(description = "middle name", example = "Степанович")
    private String middleName;

    @Size(max = 64)
    @Schema(description = "last name", example = "Егоров")
    private String lastName;

    @Size(max = 15)
    @Schema(description = "phone number", example = "(916) 111-22-33")
    private String phoneNumber;

    @Column(name = "email")
    private String email;
}
