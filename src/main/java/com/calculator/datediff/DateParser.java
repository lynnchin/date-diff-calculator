package com.calculator.datediff;

import java.util.Optional;

public interface DateParser {
    public Optional<CustomDate> parse(String inputDate);
}
