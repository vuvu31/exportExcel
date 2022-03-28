package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.account.CreateAccountDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.dto.position.CreatePositionDto;
import project.apicapstone.dto.position.UpdatePositionDto;
import project.apicapstone.entity.Account;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Position;
import project.apicapstone.service.PositionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/position")
public class PositionController {
    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public Object findAllPosition(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Position> positionPage = positionService.findAllPosition(pageable);
        return ResponseHandler.getResponse(positionService.pagingFormat(positionPage), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Position> positions = positionService.findAll();
        return ResponseHandler.getResponse(positions, HttpStatus.OK);
    }

    @PostMapping("/create-position")
    public Object createPosition(@Valid @RequestBody CreatePositionDto dto,
                                 BindingResult errors) {
        if (errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

        Position createPosition = positionService.createPosition(dto);

        return ResponseHandler.getResponse(createPosition, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findPositionById(@PathVariable("id") String id) {
        Position position = positionService.findPositionById(id);
        return ResponseHandler.getResponse(position, HttpStatus.OK);
    }

    @GetMapping("/search/{paramSearch}")
    public Object findPositionByNameOrId(@PathVariable String paramSearch) {
        List<Position> positionList = positionService.findPositionByNameOrId(paramSearch);
        if (positionList.isEmpty()) {
            return ResponseHandler.getErrors("Not found ", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(positionList, HttpStatus.OK);
    }

    @DeleteMapping()
    public Object deletePosition(@RequestParam(name = "id") String id) {
        positionService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updatePosition(@Valid @RequestBody UpdatePositionDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        positionService.updatePosition(dto, dto.getPositionId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }
}
