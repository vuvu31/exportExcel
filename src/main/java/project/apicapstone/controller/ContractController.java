package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ExportExcelContract;
import project.apicapstone.common.util.ExporterExcelEmployee;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.contract.CreateContractDto;
import project.apicapstone.dto.contract.UpdateContractDto;

import project.apicapstone.entity.Contract;

import project.apicapstone.service.ContractService;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/contract")
public class ContractController {
    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Contract> contracts = contractService.findAll();
        return ResponseHandler.getResponse(contracts, HttpStatus.OK);
    }

    @GetMapping
    public Object findAllContract(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> contractPage = contractService.findAllContract(pageable);
        return ResponseHandler.getResponse(contractService.pagingFormat(contractPage), HttpStatus.OK);
    }

    @PostMapping
    public Object createContract(@Valid @RequestBody CreateContractDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        Contract createContract = contractService.addNewContract(dto);
        return ResponseHandler.getResponse(createContract, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findContractById(@PathVariable String id) {
        Contract contract = contractService.getById(id);
        return ResponseHandler.getResponse(contract, HttpStatus.OK);
    }

    @PutMapping
    public Object updateContract(@Valid @RequestBody UpdateContractDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        contractService.update(dto, dto.getContractId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @DeleteMapping()
    public Object deleteContract(@RequestParam(name = "id") String id) {
        contractService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @GetMapping("/search/{paramSearch}")
    public Object findContractByNameOrId(@PathVariable String paramSearch) {
        List<Contract> contractList = contractService.findContractByNameOrId(paramSearch);
        if (contractList.isEmpty()) {
            return ResponseHandler.getErrors("Not found ",HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(contractList, HttpStatus.OK);
    }

// 28/03/2022
    @GetMapping("/exportListEmployee/excel")
    public Object exportListEmployeeToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerValue = "attachement; filename=HSNV.xlsx";
        String headerKey = "Content-Disposition";
        response.setHeader(headerKey, headerValue);

        List<Contract> listEmployees = contractService.findEmployeetByStatusContract();
        if (listEmployees.isEmpty()) {
            return ResponseHandler.getErrors("Not found ", HttpStatus.NOT_FOUND);
        }
        ExporterExcelEmployee excelExporter = new ExporterExcelEmployee(listEmployees);
        excelExporter.exportListEmployee(response);
        return ResponseHandler.getResponse(excelExporter, HttpStatus.OK);
    }

    @GetMapping("{id}/exportEmployee/excel")
    public Object exportEmployee(@PathVariable String id, HttpServletResponse response) throws IOException {
        List<Contract> listEmployeeID = contractService.findEmployeeIDInContract(id);

        response.setContentType("application/octet-stream");
        String headerValue = "attachement; filename=HSNV_" + id + ".xlsx";
        String headerKey = "Content-Disposition";

        response.setHeader(headerKey, headerValue);
        ExporterExcelEmployee excelExporter = new ExporterExcelEmployee(listEmployeeID);
        excelExporter.exportListEmployee(response);
        return ResponseHandler.getResponse(excelExporter, HttpStatus.OK);
    }

    @GetMapping("/exportListContract/excel")
    public Object exportListContractToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerValue = "attachement; filename=HDLD.xlsx";
        String headerKey = "Content-Disposition";
        response.setHeader(headerKey, headerValue);

        List<Contract> contractList = contractService.findEmployeetByStatusContract();
        if (contractList.isEmpty()) {
            return ResponseHandler.getErrors("Not found", HttpStatus.NOT_FOUND);
        }
        ExportExcelContract excelExporter = new ExportExcelContract(contractList);
        excelExporter.exportListContract(response);
        return ResponseHandler.getResponse(excelExporter, HttpStatus.OK);
    }
}
