package com.calculator.datediff;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateHelperTest {

    private CustomDate firstDate;
    private CustomDate secondDate;

    @Before
    public void setUp() {
        firstDate = new CustomDate(1, 1, 2001);
        secondDate = new CustomDate(1, 1, 2001);
    }


    @Test(expected=NullPointerException.class)
    public void ThrowsExceptionIfFirstDateIsNull(){
        CustomDateHelper.compareDate(null,secondDate);
    }

    @Test(expected=NullPointerException.class)
    public void ThrowsExceptionIfSecondDateIsNull(){
        CustomDateHelper.compareDate(firstDate,null);
    }

    @Test
    public void ReturnsZeroIfBothDatesAreTheSameDate() {
        Assert.assertEquals(0, CustomDateHelper.compareDate(firstDate, new CustomDate(1, 1, 2001)));
    }

    @Test
    public void ReturnsPositiveIfFirstDateIsGreaterThanSecondDate() {
        // day
        firstDate = new CustomDate(2,1,2011);
        secondDate = new CustomDate(1,1,2011);

        Assert.assertEquals(1, CustomDateHelper.compareDate(firstDate, secondDate));

        // month
        firstDate = new CustomDate(1,2,2011);
        secondDate = new CustomDate(1,1,2011);

        Assert.assertEquals(1, CustomDateHelper.compareDate(firstDate, secondDate));

        // year
        firstDate = new CustomDate(1,1,2012);
        secondDate = new CustomDate(1,1,2011);

        Assert.assertEquals(1, CustomDateHelper.compareDate(firstDate, secondDate));
    }

    @Test
    public void ReturnsNegativeIfFirstDateIsLessThanSecondDate() {
        // day
        firstDate = new CustomDate(1,1,2011);
        secondDate = new CustomDate(3,1,2011);

        Assert.assertEquals(-1, CustomDateHelper.compareDate(firstDate, secondDate));

        // month
        firstDate = new CustomDate(1,1,2011);
        secondDate = new CustomDate(1,3,2011);

        Assert.assertEquals(-1, CustomDateHelper.compareDate(firstDate, secondDate));

        // year
        firstDate = new CustomDate(1,1,2011);
        secondDate = new CustomDate(1,1,2013);

        Assert.assertEquals(-1, CustomDateHelper.compareDate(firstDate, secondDate));
    }

    @Test
    public void ReturnsTrueIfInputYearIsLeapYear(){
        Assert.assertTrue(CustomDateHelper.isLeapYear(2016));
    }

    @Test
    public void ReturnsFalseIfInputYearIsNotLeapYear(){
        Assert.assertFalse(CustomDateHelper.isLeapYear(2015));
    }
}