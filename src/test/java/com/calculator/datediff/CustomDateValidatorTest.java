package com.calculator.datediff;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateValidatorTest {

    private DateValidator validator = null;
    private Optional<CustomDate> customDateOptional = Optional.empty();
    @Before
    public void setUp(){
        validator = new CustomDateValidator();
        customDateOptional = getOptionalCustomDate(1,1,1999);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthIsValid(){
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthIsValid(){
        customDateOptional = getOptionalCustomDate(0,1,2011);
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthIsLeapYearAndGreaterThan28Days(){
        customDateOptional = getOptionalCustomDate(29,2,2000);
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthIsLeapYearAndDayIs28Days(){
        customDateOptional = getOptionalCustomDate(28,2,2000);
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthAndIsLessThan30Days(){
        customDateOptional = getOptionalCustomDate(31,4,1999);
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthAndIsGreaterThan30Days(){
        customDateOptional = getOptionalCustomDate(31,8,1999);
        boolean result = validator.validDaysInMonth(customDateOptional);
        Assert.assertEquals(true, result);
    }

    private Optional<CustomDate> getOptionalCustomDate(int day, int month, int year) {
        CustomDate customDate = new CustomDate(day, month, year);
        customDateOptional = Optional.of(customDate);
        return Optional.of(customDate);
    }
}