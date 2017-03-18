package com.calculator.datediff;

public class CustomDate implements Comparable<CustomDate>{
  private int day;
  private int month;
  private int year;

  public CustomDate(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override public int compareTo(CustomDate o) {
    if(this == null || o == null){
      throw new DateDiffException("Compare Date is null");
    }

    if(this.getYear() == o.getYear()){
      if(this.getMonth() == o.getMonth()){
        if(this.getDay() < o.getDay()){
          return -1;
        }else if(this.getDay() == o.getDay()){
          return 0;
        }else{
          return 1;
        }
      }else if(this.getMonth() > o.getMonth()){
        return 1;
      }else {
        return -1;
      }
    }else if(this.getYear() > o.getYear()){
      return 1;
    }
    return -1;
 }
}
