package com.calculator.datediff;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateParserTest {

    private DateFormatValidator dateFormatValidator;
    private DateParser dateParser;

    @Before
    public void setUp(){
        dateFormatValidator = mock(DateFormatValidator.class);
        dateParser = new CustomDateParser(dateFormatValidator);
    }

    @Test
    public void ReturnsCustomDateInstanceIfParsingSuccessful(){
        // Given
        String input = "12 12 2011";
        when(dateFormatValidator.validate(anyString())).thenReturn(true);

        // When
        Optional<CustomDate> optionalCustomDate = dateParser.parse(input);

        // Then
        Assert.assertTrue(optionalCustomDate.isPresent());
        Assert.assertThat(optionalCustomDate.get().getDay(),is(12));
        Assert.assertThat(optionalCustomDate.get().getMonth(),is(12));
        Assert.assertThat(optionalCustomDate.get().getYear(),is(2011));
    }

    @Test
    public void ReturnsCustomDateInstanceIfDateFormatIsInvalid(){
        // Given
        String input = "12 12 2020";
        when(dateFormatValidator.validate(anyString())).thenReturn(false);

        // When
        Optional<CustomDate> optionalCustomDate = dateParser.parse(input);

        // Then
        Assert.assertFalse(optionalCustomDate.isPresent());
    }
}