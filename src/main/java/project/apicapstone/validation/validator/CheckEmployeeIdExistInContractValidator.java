package project.apicapstone.validation.validator;

import project.apicapstone.entity.Contract;
import project.apicapstone.service.ContractService;
import project.apicapstone.validation.annonation.CheckDepartmentId;
import project.apicapstone.validation.annonation.CheckEmployeeIdExistInContract;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckEmployeeIdExistInContractValidator implements ConstraintValidator<CheckEmployeeIdExistInContract, String> {
    private ContractService service;

    public CheckEmployeeIdExistInContractValidator(ContractService service) {
        this.service = service;
    }

    private String message;

    @Override
    public void initialize(CheckEmployeeIdExistInContract constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<Contract> contractList = service.existByEmployeeId(s);
        if (contractList.size() > 0) {
            return false;
        }
        return true;
    }
}
