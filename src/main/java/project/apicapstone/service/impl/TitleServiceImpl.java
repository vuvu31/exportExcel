package project.apicapstone.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.title.CreateTitleDto;
import project.apicapstone.dto.title.PagingFormatTitleDto;
import project.apicapstone.dto.title.UpdateTitleDto;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Position;
import project.apicapstone.entity.Title;
import project.apicapstone.repository.DepartmentRepository;
import project.apicapstone.repository.PositionRepository;
import project.apicapstone.repository.TitleRepository;
import project.apicapstone.service.TitleService;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    private TitleRepository titleRepository;
    private PositionRepository positionRepository;
    private DepartmentRepository departmentRepository;

    public TitleServiceImpl(TitleRepository titleRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository) {
        this.titleRepository = titleRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    @Override
    public Page<Title> findAllTitle(Pageable pageable) {
        return titleRepository.findAllAllTitle(pageable);
    }

    @Override
    public Object pagingFormat(Page<Title> titlePage) {
        PagingFormatTitleDto dto = new PagingFormatTitleDto();
        dto.setPageSize(titlePage.getSize());
        dto.setTotalRecordCount(titlePage.getTotalElements());
        dto.setPageNumber(titlePage.getNumber());
        dto.setRecords(titlePage.toList());
        return dto;
    }


    @Override
    public Title createTitle(CreateTitleDto dto) {
        Title newTitle = new Title();
        newTitle.setTitleId(dto.getTitleId());
        newTitle.setJobTitle(dto.getJobTitle());
        Position position = positionRepository.getById(dto.getPositionId());
        newTitle.setPosition(position);
        Department department = departmentRepository.getById(dto.getDepartmentId());
        newTitle.setDepartment(department);
        return titleRepository.save(newTitle);
    }

    @Override
    public boolean isExisted(String s) {
        return titleRepository.existsById(s);
    }

    @Override
    public void deleteById(String id) {
        titleRepository.deleteById(id);
    }

    @Override
    public List<Title> findTitleByNameOrId(String paramSearch) {
        return titleRepository.findTitlesByNameOrId(paramSearch);
    }

    @Override
    public Title findTitleById(String id) {
        return titleRepository.getById(id);
    }

    @Override
    public void updateTitle(UpdateTitleDto dto, String titleId) {
        Title updateTitle = titleRepository.getById(titleId);
        updateTitle.setJobTitle(dto.getJobTitle());
        Position position = positionRepository.getById(dto.getPositionId());
        updateTitle.setPosition(position);
        Department department = departmentRepository.getById(dto.getDepartmentId());
        updateTitle.setDepartment(department);
        titleRepository.save(updateTitle);
    }

    @Override
    public Title findTitleByPositionIdAndDepartmentId(String positionId, String departmentId) {
        return titleRepository.findTitleByPositionIdAndDepartmentId(positionId, departmentId);
    }
}
