package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import project.apicapstone.dto.dependant.CreateDependantDto;
import project.apicapstone.dto.dependant.UpdateDependantDto;
import project.apicapstone.entity.Dependant;

import java.util.List;

public interface DependantService {
    List<Dependant> findAll();

    Page<Dependant> findAllDependant(Pageable pageable);

    Object pagingFormat(Page<Dependant> dependantPage);

    Dependant createDependant(CreateDependantDto dto);

    boolean isExisted(String s);

    void deleteById(String id);

    void updateDependant(UpdateDependantDto dto, String dependantId);

    Dependant findDependantById(String id);

    List<Dependant> findDependantByNameOrId(String paramSearch);
}
