package project.apicapstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.apicapstone.service.CriteriaService;


@RestController
@RequestMapping(value = "/api/criteria")
public class CriteriaController {
    private CriteriaService criteriaService;

    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }
}
