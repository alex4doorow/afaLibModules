package com.afa.core.dto.customers;

import com.afa.core.dto.BasePagedFilter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"PMD.CommentRequired", "PMD.TooManyFields"})
public class CustomerSearchPagedFilter extends BasePagedFilter {

    @NotNull
    @Valid
    private CustomerConditionsDto conditions;

}
