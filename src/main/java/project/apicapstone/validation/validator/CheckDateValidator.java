package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.DateValidator;
import project.apicapstone.validation.annonation.CheckDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDate, LocalDate> {
    //    private static final String DATE_PATTERN = "MM/dd/yyyy";
    private String message;
    private static final String DATE_PATTERN = "dd/MM/yyyy";


    @Override
    public void initialize(CheckDate constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(LocalDate customDateField, ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(String.valueOf(customDateField));
            return true;
        } catch (ParseException e) {
            ValidatorUtils.addError(cxt, message);
            return false;
        }
    }
}