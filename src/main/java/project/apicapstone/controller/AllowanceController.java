package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.allowance.CreateAllowanceDto;
import project.apicapstone.dto.allowance.UpdateAllowanceDto;
import project.apicapstone.dto.applicant.CreateApplicantDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Applicant;
import project.apicapstone.entity.Employee;
import project.apicapstone.service.AllowanceService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/allowance")
public class AllowanceController {
    private AllowanceService allowanceService;

    public AllowanceController(AllowanceService allowanceService) {
        this.allowanceService = allowanceService;
    }

    @GetMapping
    public Object findAllAllowance(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Allowance> allowancePage = allowanceService.findAllAllowance(pageable);
        return ResponseHandler.getResponse(allowanceService.pagingFormat(allowancePage), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Allowance> allowances = allowanceService.findAll();
        return ResponseHandler.getResponse(allowances, HttpStatus.OK);
    }

    @PostMapping("/create-allowance")
    public Object createAllowance(@Valid @RequestBody CreateAllowanceDto dto,
                                  BindingResult errors) {
        if (errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

        Allowance createAllowance = allowanceService.createAllowance(dto);

        return ResponseHandler.getResponse(createAllowance, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public Object deleteAllowance(@RequestParam(name = "id") String id) {
        allowanceService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateAllowance(@Valid @RequestBody UpdateAllowanceDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        allowanceService.updateAllowance(dto, dto.getAllowanceId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findAllowanceById(@PathVariable("id") String id) {
        Allowance allowance = allowanceService.findAllowanceById(id);
        return ResponseHandler.getResponse(allowance, HttpStatus.OK);
    }

    @GetMapping("/search/{paramSearch}")
    public Object findAllowanceByNameOrId(@PathVariable String paramSearch) {
        List<Allowance> allowanceList = allowanceService.findAllowanceByNameOrId(paramSearch);
        if (allowanceList.isEmpty()) {
            return ResponseHandler.getErrors("Not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(allowanceList, HttpStatus.OK);
    }
}
