package com.calculator.datediff;

public class DateDiffCalculator {

    private DateValidator customDateValidator;
    private DateFormatValidator customDateFormatValidator;

    public DateDiffCalculator(DateValidator customDateValidator, DateFormatValidator customDateFormatValidator){
        this.customDateFormatValidator = customDateFormatValidator;
        this.customDateValidator = customDateValidator;
    }

}
