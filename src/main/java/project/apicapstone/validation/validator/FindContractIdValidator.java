package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.ContractService;
import project.apicapstone.validation.annonation.FindContractId;
import project.apicapstone.validation.annonation.FindTitleId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindContractIdValidator implements ConstraintValidator<FindContractId, String> {
    private String message;
    private ContractService contractService;
    public FindContractIdValidator(ContractService contractService){
        this.contractService=contractService;
    }
    @Override
    public void initialize(FindContractId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = contractService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Contract Id not blank");
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
