package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.entity.JobPosting;
import project.apicapstone.service.JobPostingService;
import project.apicapstone.validation.annonation.UniqueAccountId;
import project.apicapstone.validation.annonation.UniqueJobPostingId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueJobPostingIdValidator implements ConstraintValidator<UniqueJobPostingId, String> {
    private String message;
    private JobPostingService jobPostingService;

    public UniqueJobPostingIdValidator(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @Override
    public void initialize(UniqueJobPostingId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = jobPostingService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "JobPosting Id not blank");
            return false;
        }
        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
