package com.afa.core.exceptions;

import com.afa.core.enums.DevicerErrors;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.List;

@Getter
public class DevicerException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;
    private final List<ViolationItem> violations;

    public DevicerException(final DevicerErrors error, final Object... args) {
        super(error.name());
        this.errorCode = error.name();
        this.errorMessage = (args == null || args.length == 0)
                ? error.getErrorMessage()
                : MessageFormat.format(error.getErrorMessage(), args);
        this.violations = null;
    }

    public DevicerException(
            final DevicerErrors error,
            final String errorMessage,
            final List<ViolationItem> violations
    ) {
        super(error.name());
        this.errorCode = error.name();
        this.errorMessage = errorMessage;
        this.violations = violations == null ? List.of() : violations;
    }
}
