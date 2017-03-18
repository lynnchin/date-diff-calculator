package com.calculator.datediff;

import java.util.Optional;

/**
 * Created by lynnchin on 18/3/17.
 */
public interface DateValidator {
    public boolean validDaysInMonth(Optional<CustomDate> customDate);
}
