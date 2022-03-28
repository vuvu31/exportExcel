package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.repository.CriteriaRepository;
import project.apicapstone.service.CriteriaService;
@Service
public class CriteriaServiceImpl implements CriteriaService {
    private CriteriaRepository criteriaRepository;
    public CriteriaServiceImpl(CriteriaRepository criteriaRepository){
        this.criteriaRepository=criteriaRepository;
    }
}
