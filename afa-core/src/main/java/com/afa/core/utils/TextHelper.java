package com.afa.core.utils;

@SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
public final class TextHelper {

    private TextHelper() {
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
