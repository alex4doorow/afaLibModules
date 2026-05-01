package com.afa.core.utils;

import java.math.BigDecimal;

@SuppressWarnings("PMD.TooManyMethods")
public final class NumericHelper {

    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

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
}
