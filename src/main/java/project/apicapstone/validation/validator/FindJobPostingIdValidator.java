package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.JobPostingService;
import project.apicapstone.validation.annonation.FindJobPostingId;
import project.apicapstone.validation.annonation.FindTitleId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindJobPostingIdValidator implements ConstraintValidator<FindJobPostingId, String> {
    private String message;
    private JobPostingService jobPostingService;
    public FindJobPostingIdValidator(JobPostingService jobPostingService){
        this.jobPostingService=jobPostingService;
    }
    @Override
    public void initialize(FindJobPostingId constraintAnnotation) {
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
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
