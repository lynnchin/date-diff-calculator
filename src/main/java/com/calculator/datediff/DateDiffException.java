package com.calculator.datediff;

public class DateDiffException extends RuntimeException {
    public DateDiffException() {
        super();
    }
    public DateDiffException(String s) {
        super(s);
    }

    public String getMessage(){
        return super.getMessage();
    }

}
