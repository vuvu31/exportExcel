package project.apicapstone.service;

import project.apicapstone.dto.subarea.CreateSubareaDto;
import project.apicapstone.dto.subarea.UpdateSubareaDto;
import project.apicapstone.entity.Subarea;

import java.util.List;

public interface SubareaService {
    boolean isExisted(String s);

    Subarea createSubarea(CreateSubareaDto dto);

    List<Subarea> findAll();

    void deleteById(String id);

    void updateSubarea(UpdateSubareaDto dto, String subareaId);
}
