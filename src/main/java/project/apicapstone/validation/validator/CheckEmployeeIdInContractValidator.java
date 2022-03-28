package project.apicapstone.validation.validator;


import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.dto.contract.UpdateContractDto;

import project.apicapstone.service.ContractService;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.CheckEmployeeIdInContract;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckEmployeeIdInContractValidator implements ConstraintValidator<CheckEmployeeIdInContract, UpdateContractDto> {
    private ContractService service;
    private EmployeeService employeeService;
    private String message;

    public CheckEmployeeIdInContractValidator(ContractService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @Override
    public void initialize(CheckEmployeeIdInContract constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(UpdateContractDto updateContractDto, ConstraintValidatorContext constraintValidatorContext) {
        String contractId = service.findEmployeeIdWithContract(updateContractDto.getEmployeeId());
        String id = updateContractDto.getContractId();
        boolean isExisted = employeeService.isExisted(updateContractDto.getEmployeeId());
        if (!isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, "Không tìm thấy mã nhân viên");
            return false;
        }
        if (contractId.equals(id)) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        }


    }
}
