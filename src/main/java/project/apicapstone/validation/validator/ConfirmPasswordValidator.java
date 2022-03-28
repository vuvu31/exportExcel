package project.apicapstone.validation.validator;

import project.apicapstone.dto.account.CreateAccountDto;
import project.apicapstone.validation.annonation.ConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, CreateAccountDto> {
    private String message;

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(CreateAccountDto dto, ConstraintValidatorContext constraintValidatorContext) {
        if (dto.getPassword().equals(dto.getConfirmPassword())) {
            return true;
        } else {
            return false;
        }

    }
}