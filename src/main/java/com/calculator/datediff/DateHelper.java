package com.calculator.datediff;

public class DateHelper {

  // Compare Date and return which one is bigger
  public int compareDate(CustomDate customDate1, CustomDate customDate2) {
    return -1;
  }

  // Checks for leap year

  public static boolean isLeapYear(int year){
    if (year % 4 != 0) {
      return false;
    } else if (year % 400 == 0) {
      return true;
    } else if (year % 100 == 0) {
      return false;
    } else {
      return true;
    }
  }

  //TODO:
  /*
    Returns true if the the input day and month is valid. Otherwise, returns false
   */
  public static boolean isValidDaysInMonth(int day, int month, int year){

    return false;
  }

}

