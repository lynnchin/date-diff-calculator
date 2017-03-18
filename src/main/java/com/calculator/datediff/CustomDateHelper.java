package com.calculator.datediff;

public class CustomDateHelper {

  // Compare Date and return which one is bigger
  public static int compareDate(CustomDate firstDate, CustomDate secondDate) {
    return firstDate.compareTo(secondDate);
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
}

