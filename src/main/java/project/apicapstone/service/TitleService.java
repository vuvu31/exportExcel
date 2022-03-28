package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import project.apicapstone.dto.title.CreateTitleDto;
import project.apicapstone.dto.title.UpdateTitleDto;
import project.apicapstone.entity.Title;

import java.util.List;

public interface TitleService {
    List<Title> findAll();

    Page<Title> findAllTitle(Pageable pageable);


    Object pagingFormat(Page<Title> titlePage);

    Title createTitle(CreateTitleDto dto);

    boolean isExisted(String s);

    void deleteById(String id);

    List<Title> findTitleByNameOrId(String paramSearch);

    Title findTitleById(String id);

    void updateTitle(UpdateTitleDto dto, String titleId);

    Title findTitleByPositionIdAndDepartmentId(String positionId, String departmentId);
}
