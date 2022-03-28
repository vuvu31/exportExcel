package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.dto.subarea.CreateSubareaDto;
import project.apicapstone.dto.subarea.UpdateSubareaDto;
import project.apicapstone.entity.Subarea;
import project.apicapstone.repository.AreaRepository;
import project.apicapstone.repository.SubareaRepository;
import project.apicapstone.service.SubareaService;

import java.util.List;

@Service
public class SubareaServiceImpl implements SubareaService {
    private SubareaRepository subareaRepository;
    private AreaRepository areaRepository;

    public SubareaServiceImpl(SubareaRepository subareaRepository, AreaRepository areaRepository) {
        this.subareaRepository = subareaRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public boolean isExisted(String s) {
        return subareaRepository.existsById(s);
    }

    @Override
    public Subarea createSubarea(CreateSubareaDto dto) {
        Subarea newSubarea = new Subarea();
        newSubarea.setSubareaId(dto.getSubareaId());
        newSubarea.setName(dto.getName());
        newSubarea.setDescription(dto.getDescription());
        newSubarea.setArea(areaRepository.getById(dto.getAreaId()));
        return subareaRepository.save(newSubarea);
    }

    @Override
    public List<Subarea> findAll() {
        return subareaRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        subareaRepository.deleteById(id);
    }

    @Override
    public void updateSubarea(UpdateSubareaDto dto, String subareaId) {
        Subarea subarea = subareaRepository.getById(dto.getSubareaId());
        subarea.setName(dto.getName());
        subarea.setDescription(dto.getDescription());
        subarea.setArea(areaRepository.getById(dto.getAreaId()));
        subareaRepository.save(subarea);
    }
}
