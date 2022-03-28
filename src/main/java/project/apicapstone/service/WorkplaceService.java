package project.apicapstone.service;

import project.apicapstone.dto.workplace.CreateWorkplaceDto;
import project.apicapstone.dto.workplace.UpdateWorkplaceDto;
import project.apicapstone.entity.Workplace;

import java.util.List;

public interface WorkplaceService {
    List<Workplace> findAll();

    Workplace createWorkplace(CreateWorkplaceDto dto);

    boolean isExisted(String s);

    void deleteById(String id);

    void updateWorkplace(UpdateWorkplaceDto dto, String workplaceId);
}
