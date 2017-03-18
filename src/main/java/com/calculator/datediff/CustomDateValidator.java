package com.calculator.datediff;

import java.util.Optional;

/**
 * Created by lynnchin on 18/3/17.
 */
public class CustomDateValidator implements DateValidator {

    public static final int[] monthsWithThirthyOneDays = new int[]{1, 3, 5, 7, 8, 10, 12};
    public static final int[] monthsWithThirthyDays = new int[]{4, 6, 9, 11};

    public static final int DAYS_FEBUARY_LEAP_YEAR = 28;
    public static final int DAYS_FEBUARY_NON_LEAP_YEAR = 29;

    // TODO: Refactor this later...
    @Override
    public boolean validDaysInMonth(Optional<CustomDate> customDateOptional) {
        if(!customDateOptional.isPresent()){
            return false;
        }

        CustomDate customDate = customDateOptional.get();

        if (customDate.getMonth() == 2) {
            return validateDaysInLeapYear(customDate.getDay(),customDate.getYear());
        }
        return validateDaysInMonthWithThirtyDays(customDate.getDay(), customDate.getMonth()) ||
                validateDaysInMonthWithThirtyOneDays(customDate.getDay(), customDate.getMonth());
    }

    // TODO: DRY this up!
    private boolean validateDaysInLeapYear(int day, int year){
        if (CustomDateHelper.isLeapYear(year)) {
            if (day <= DAYS_FEBUARY_LEAP_YEAR) {
                return true;
            } else {
                return false;
            }
        } else {
            if (day <= DAYS_FEBUARY_NON_LEAP_YEAR) {
                return true;
            } else {
                return false;
            }
        }
    }

    // TODO: DRY THIS up!
    private boolean validateDaysInMonthWithThirtyDays(int day, int month) {
        for (int currentMonth : monthsWithThirthyDays) {
            if (currentMonth == month) {
                if (day > 0 && day < 31) {
                    return true;
                }
            }
        }

        return false;
    }

    // TODO: DRY this up!
    private boolean validateDaysInMonthWithThirtyOneDays(int day, int month) {
        for (int currentMonth : monthsWithThirthyOneDays) {
            if (currentMonth == month) {
                if (day > 0 && day <= 31) {
                    return true;
                }
            }
        }

        return false;
    }

}
