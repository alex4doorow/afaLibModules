package com.afa.core.utils;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
public final class TextHelper {

    private TextHelper() {
    }

    public static String numberDigit(final String stringValue) {

        if (StringUtils.isEmpty(stringValue)) {
            return "";
        }
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringValue.length(); i++) {

            if (Character.isDigit(stringValue.charAt(i))) {
                result.append(stringValue.charAt(i));
            }
        }
        return result.toString();
    }

    public static String formatPhoneNumber(final String rawPhone) {
        if (rawPhone == null || rawPhone.trim().isEmpty()) {
            return null;
        }

        String digits = rawPhone.trim();

        // убрать запятую в конце
        if (digits.endsWith(",")) {
            digits = digits.substring(0, digits.length() - 1);
        }

        // оставить только цифры
        digits = digits.replaceAll("\\D", "");

        // если номер начинается с 7 или 8 и длина 11 — убираем первую цифру
        if (digits.length() == 11 && (digits.startsWith("7") || digits.startsWith("8"))) {
            digits = digits.substring(1);
        }

        if (digits.length() != 10) {
            return rawPhone;
        }

        return String.format("(%s) %s-%s-%s",
                digits.substring(0, 3),
                digits.substring(3, 6),
                digits.substring(6, 8),
                digits.substring(8, 10)
        );
    }
}
