package project.apicapstone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;

import project.apicapstone.dto.subarea.CreateSubareaDto;
import project.apicapstone.dto.subarea.UpdateSubareaDto;
import project.apicapstone.entity.Subarea;

import project.apicapstone.service.SubareaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subarea")
public class SubareaController {
    private SubareaService subareaService;

    public SubareaController(SubareaService subareaService) {
        this.subareaService = subareaService;
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Subarea> workplaces = subareaService.findAll();
        return ResponseHandler.getResponse(workplaces, HttpStatus.OK);
    }

    @PostMapping("/create-subarea")
    public Object createSubarea(@Valid @RequestBody CreateSubareaDto dto,
                                BindingResult errors) {
        if (errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

        Subarea createSubarea = subareaService.createSubarea(dto);

        return ResponseHandler.getResponse(createSubarea, HttpStatus.CREATED);
    }
    @DeleteMapping()
    public Object deleteSubarea(@RequestParam(name = "id") String id) {
        subareaService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateSubarea(@Valid @RequestBody UpdateSubareaDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        subareaService.updateSubarea(dto, dto.getSubareaId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }
}
