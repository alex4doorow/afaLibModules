package com.afa.core.dto.orders;

import com.afa.core.dto.BasePagedFilter;
import com.afa.core.enums.ReportPeriodTypes;
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
public class OrderPagedFilter extends BasePagedFilter {

    @NotNull
    @Valid
    private OrderConditionsDto conditions;

    private ReportPeriodTypes periodType;
}
