package com.afa.core.dto.customers;

import com.afa.core.dto.BasePagedFilter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"PMD.CommentRequired", "PMD.TooManyFields"})
public class CustomerSearchPagedFilter extends BasePagedFilter {

    @NotNull
    @Valid
    private CustomerConditionsDto conditions;

}
