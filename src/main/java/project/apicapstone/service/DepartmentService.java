package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.apicapstone.dto.department.CreateDepartmentDto;
import project.apicapstone.dto.department.PagingFormatDepartmentDto;
import project.apicapstone.dto.department.UpdateDepartmentDto;
import project.apicapstone.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department addNewDepartment(CreateDepartmentDto dto);

    boolean isExisted(String s);

    Page<Department> findAllDepartment(Pageable pageable);

    PagingFormatDepartmentDto pagingFormat(Page<Department> departmentPage);

    Department findEmployeeById(String id);

    List<Department> findDepartmentByNameOrId(String paramSearch);

    void deleteById(String id);

    void updateDepartment(UpdateDepartmentDto dto, String departmentId);
}
