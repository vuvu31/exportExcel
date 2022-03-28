package project.apicapstone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.department.CreateDepartmentDto;
import project.apicapstone.dto.department.PagingFormatDepartmentDto;
import project.apicapstone.dto.department.UpdateDepartmentDto;
import project.apicapstone.entity.Department;
import project.apicapstone.repository.DepartmentRepository;
import project.apicapstone.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addNewDepartment(CreateDepartmentDto dto) {
        Department addDepartment = new Department();
        addDepartment.setDepartmentId(dto.getDepartmentId());
        addDepartment.setDepartmentName(dto.getDepartmentName());
        return departmentRepository.save(addDepartment);
    }

    @Override
    public boolean isExisted(String s) {
        return departmentRepository.existsById(s);
    }

    @Override
    public Page<Department> findAllDepartment(Pageable pageable) {
        return departmentRepository.findALlDepartment(pageable);
    }

    @Override
    public PagingFormatDepartmentDto pagingFormat(Page<Department> departmentPage) {
        PagingFormatDepartmentDto dto = new PagingFormatDepartmentDto();
        dto.setPageSize(departmentPage.getSize());
        dto.setTotalRecordCount(departmentPage.getTotalElements());
        dto.setPageNumber(departmentPage.getNumber());
        dto.setRecords(departmentPage.toList());
        return dto;
    }

    @Override
    public Department findEmployeeById(String id) {
        return departmentRepository.getById(id);
    }

    @Override
    public List<Department> findDepartmentByNameOrId(String paramSearch) {
        return departmentRepository.findDepartmentsByNameOrId(paramSearch);
    }

    @Override
    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(UpdateDepartmentDto dto, String departmentId) {
        Department updateDepartment = departmentRepository.getById(departmentId);

        updateDepartment.setDepartmentName(dto.getDepartmentName());
         departmentRepository.save(updateDepartment);
    }


}
