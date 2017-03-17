package com.calculator.datediff;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDateFormatValidator implements DateFormatValidator {

  private static final String DATE_PATTERN =
      "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

  private Pattern pattern;
  private Matcher matcher;

  public void DateValidator(){
    pattern = Pattern.compile(DATE_PATTERN);
  }

  public boolean validate(String dateAsString) {
    return false;
  }
}
