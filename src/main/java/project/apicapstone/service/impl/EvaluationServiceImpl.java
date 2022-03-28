package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.repository.EvaluationRepository;
import project.apicapstone.service.EvaluationService;
@Service
public class EvaluationServiceImpl implements EvaluationService {
    private EvaluationRepository evaluationRepository;
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository){
        this.evaluationRepository=evaluationRepository;
    }
}
