package project.apicapstone.service.impl;

import project.apicapstone.service.DateValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorImpl implements DateValidator {
    private String dateFormat;

    public DateValidatorImpl(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
