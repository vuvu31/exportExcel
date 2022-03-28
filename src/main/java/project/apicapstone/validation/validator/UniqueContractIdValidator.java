package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.entity.Contract;
import project.apicapstone.service.ContractService;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.UniqueContractId;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueContractIdValidator implements ConstraintValidator<UniqueContractId, String> {
    private ContractService service;
    private String message;

    public UniqueContractIdValidator(ContractService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueContractId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(s);

        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
