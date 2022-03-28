package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.dto.area.CreateAreaDto;
import project.apicapstone.dto.area.UpdateAreaDto;
import project.apicapstone.entity.Area;
import project.apicapstone.repository.AreaRepository;
import project.apicapstone.service.AreaService;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area createAccount(CreateAreaDto dto) {
        Area newArea = new Area();
        newArea.setAreaId(dto.getAreaId());
        newArea.setName(dto.getName());
        newArea.setDescription(dto.getDescription());
        return areaRepository.save(newArea);
    }

    @Override
    public boolean isExisted(String s) {
        return areaRepository.existsById(s);
    }

    @Override
    public void deleteById(String id) {
        areaRepository.deleteById(id);
    }

    @Override
    public void updateArea(UpdateAreaDto dto, String areaId) {
        Area area = areaRepository.getById(dto.getAreaId());
        area.setName(dto.getName());
        area.setDescription(dto.getDescription());
        areaRepository.save(area);
    }
}
