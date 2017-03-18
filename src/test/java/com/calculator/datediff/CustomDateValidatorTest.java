package com.calculator.datediff;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateValidatorTest {

    private DateValidator validator = null;
    private CustomDate customDate = null;
    @Before
    public void setUp(){
        validator = new CustomDateValidator();
        customDate = new CustomDate(1,1,2011);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthIsValid(){
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthIsValid(){
        customDate = new CustomDate(0,1,2011);
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthIsLeapYearAndGreaterThan28Days(){
        customDate = new CustomDate(29,2,2016);
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthIsLeapYearAndDayIs28Days(){
        customDate = new CustomDate(28,2,2016);
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnsFalseIfValidateDaysInMonthAndIsLessThan30Days(){
        customDate = new CustomDate(31,4,2017);
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(false, result);
    }

    @Test
    public void returnsTrueIfValidateDaysInMonthAndIsGreaterThan30Days(){
        customDate = new CustomDate(31,8,2017);
        boolean result = validator.validDaysInMonth(customDate);
        Assert.assertEquals(true, result);
    }
}