package com.afa.core.dto;

import com.afa.core.enums.DevicerErrors;
import com.afa.core.exceptions.DevicerException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePagedFilter {
    private final static int MAX_RESULTS_ON_PAGE = 100;
    private final static String SORTED_ASC = "asc";
    private final static String SORTED_DESC = "desc";

    @Builder.Default
    @Schema(description = "results on page", example = "10")
    private Integer resultsOnPage = 10;

    @Builder.Default
    @Schema(description = "result's page number", example = "3")
    private Integer pageNumber = 1;

    @Schema(description = "list sorted fields", example = "tsCreated asc, name desc, status asc")
    private String sortedBy;

    public void setSortedBy(final String sortedBy) {
        this.sortedBy = sortedBy.trim().replaceAll(" +", " ");
    }

    @JsonIgnore
    public boolean isSortedByEmpty() {
        return StringUtils.isEmpty(sortedBy);
    }

    @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.UseVarargs"})
    public PageRequest createPageRequest(
            final String orderContext,
            final Field[] fields) {

        final Sort sort;
        if (StringUtils.isEmpty(orderContext)) {
            sort = Sort.unsorted();
        } else {
            final String[] stringOrders = orderContext.split(",");
            final Sort.Order[] sortOrders = new Sort.Order[stringOrders.length];
            for (int i = 0; i < stringOrders.length; i++) {

                final String[] sortOrder = stringOrders[i].trim().split(" ");

                final String fieldName = sortOrder[0].trim();
                if (!validateSortFields(fieldName, fields)) {
                    throw new DevicerException(DevicerErrors.DB_FIELD_SORT_NOT_FOUND, fieldName);
                }
                final String ascDesc = sortOrder.length > 1 ? sortOrder[1].trim().toLowerCase(Locale.getDefault()) : SORTED_ASC;

                switch (ascDesc) {
                    case SORTED_ASC:
                        sortOrders[i] = Sort.Order.asc(fieldName);
                        break;
                    case SORTED_DESC:
                        sortOrders[i] = Sort.Order.desc(fieldName);
                        break;
                    default: {
                        throw new DevicerException(DevicerErrors.DB_FIELD_ASC_DESC_SORT_NOT_FOUND, ascDesc);
                    }
                }
            }
            sort = Sort.by(sortOrders);
        }

        return PageRequest.of(Math.max(pageNumber - 1, 0),
                resultsOnPage,
                sort);
    }

    public PageRequest createPageRequest(final List<Sort.Order> orders) {
        final Sort sort = (orders == null || orders.isEmpty())
                ? Sort.unsorted()
                : Sort.by(orders);
        return PageRequest.of(Math.max(pageNumber - 1, 0),
                resultsOnPage,
                sort);
    }

    @SuppressWarnings("PMD.UseVarargs")
    private boolean validateSortFields(
            final String stringField,
            final Field[] fields) {

        for (final Field field : fields) {
            if (stringField.split("\\.").length > 1
                    && stringField.split("\\.")[0].equalsIgnoreCase(field.getName())) {
                return true;
            }
            if (field.getName().equals(stringField)) {
                return true;
            }
        }
        return false;
    }
}
