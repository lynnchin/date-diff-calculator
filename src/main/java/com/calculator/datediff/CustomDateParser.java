package com.calculator.datediff;

import java.util.Optional;

/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateParser implements DateParser{
    private DateFormatValidator dateFormatValidator;

    public CustomDateParser(DateFormatValidator dateFormatValidator){
        this.dateFormatValidator = dateFormatValidator;
    }

    @Override
    public Optional<CustomDate> parse(String inputDate) {
        if(dateFormatValidator.validate(inputDate)){
            String[] splitDate = inputDate.split(" ");
            CustomDate customDate = new CustomDate();
            customDate.setDay(Integer.parseInt(splitDate[0]));
            customDate.setMonth(Integer.parseInt(splitDate[1]));
            customDate.setYear(Integer.parseInt(splitDate[2]));
            return Optional.of(customDate);
        }

        return Optional.empty();
    }
}
