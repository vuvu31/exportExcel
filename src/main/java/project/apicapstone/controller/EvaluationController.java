package project.apicapstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.apicapstone.service.EvaluationService;

@RestController
@RequestMapping(value = "/api/evaluation")
public class EvaluationController {
    private EvaluationService evaluationService;
    public EvaluationController(EvaluationService evaluationService){
        this.evaluationService=evaluationService;
    }
}
