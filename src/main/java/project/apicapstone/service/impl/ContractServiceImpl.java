package project.apicapstone.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.contract.CreateContractDto;
import project.apicapstone.dto.contract.PagingFormatContractDto;
import project.apicapstone.dto.contract.UpdateContractDto;
import project.apicapstone.entity.Contract;
import project.apicapstone.entity.Employee;
import project.apicapstone.repository.ContractRepository;
import project.apicapstone.repository.EmployeeRepository;
import project.apicapstone.service.ContractService;

import java.time.Duration;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    private ContractRepository contractRepository;
    private EmployeeRepository employeeRepository;

    public ContractServiceImpl(ContractRepository contractRepository, EmployeeRepository employeeRepository) {
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract addNewContract(CreateContractDto dto) {
        Contract addContract = new Contract();
        addContract.setContractId(dto.getContractId());
        addContract.setContractName(dto.getContractName());
        addContract.setStartDate(dto.getStartDate());
        addContract.setEndDate(dto.getStartDate().plusMonths(dto.getDuration()));
        addContract.setStatus(dto.getStatus());
        addContract.setSalary(dto.getSalary());
        addContract.setType(dto.getType());
        addContract.setDuration(dto.getDuration());
        addContract.setSignDate(dto.getSignDate());
        addContract.setWage(dto.getWage());
        addContract.setNote(dto.getNote());
        addContract.setAttachedFile(dto.getAttachedFile());
        Employee employee = employeeRepository.getById(dto.getEmployeeId());
        addContract.setEmployee(employee);
        return contractRepository.save(addContract);
    }

    @Override
    public boolean isExisted(String s) {
        return contractRepository.existsById(s);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }

    @Override
    public PagingFormatContractDto pagingFormat(Page<Contract> contractPage) {
        PagingFormatContractDto dto = new PagingFormatContractDto();
        dto.setPageSize(contractPage.getSize());
        dto.setTotalRecordCount(contractPage.getTotalElements());
        dto.setPageNumber(contractPage.getNumber());
        dto.setRecords(contractPage.toList());
        return dto;
    }

    @Override
    public Contract getById(String id) {
        return contractRepository.getById(id);
    }

    @Override
    public void update(UpdateContractDto dto, String contractId) {
        Contract contract = contractRepository.getById(contractId);
        contract.setContractName(dto.getContractName());
        contract.setStartDate(dto.getStartDate());
        contract.setEndDate(dto.getStartDate().plusMonths(dto.getDuration()));
        contract.setStatus(dto.getStatus());
        contract.setSalary(dto.getSalary());
        contract.setType(dto.getType());
        contract.setDuration(dto.getDuration());
        contract.setSignDate(dto.getSignDate());
        contract.setWage(dto.getWage());
        contract.setNote(dto.getNote());
        contract.setAttachedFile(dto.getAttachedFile());
        Employee employee = employeeRepository.getById(dto.getEmployeeId());
        contract.setEmployee(employee);
        contractRepository.save(contract);
    }

    @Override
    public void deleteById(String id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findContractByNameOrId(String paramSearch) {
        return contractRepository.findContractByNameOrId(paramSearch);
    }

    @Override
    public List<Contract> existByEmployeeId(String s) {
        return contractRepository.findEmployeeIdInContract(s);
    }

    @Override
    public String findEmployeeIdWithContract(String employeeId) {
        return contractRepository.findEmployeeIdWithContract(employeeId);
    }
// 28/03/2022
    @Override
    public List<Contract> findEmployeeIDInContract(String id){
        return contractRepository.findEmployeeIdInContract(id);
    }
    @Override
    public List<Contract> findEmployeetByStatusContract(){
        return contractRepository.findContractByStatus("Còn hiệu lực");
    }
}
