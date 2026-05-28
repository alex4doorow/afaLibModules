package com.afa.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

@SuppressWarnings("PMD.TooManyMethods")
public final class NumericHelper {

    public static final String NUMBER_FORMAT_MONEY = "#,##0.00";
    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    public static final BigDecimal ONE_THOUSAND = BigDecimal.valueOf(1000);

    private NumericHelper() {
    }

    public static boolean isNumeric(final String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str); // или Long.parseLong(str)
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String formatNumber(final BigDecimal value, final String pattern) {
        final DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }

    public static BigDecimal weightG2Kg(final int weightG) {
        return BigDecimal.valueOf(0.001).multiply(BigDecimal.valueOf(weightG));
    }

    public static String numberDigit(final String value) {

        if (StringUtils.isBlank(value)) {
            return "";
        }

        return value.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

}
