package project.apicapstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.apicapstone.service.SkillService;

@RestController
@RequestMapping(value = "/api/skill")
public class SkillController {
    private SkillService skillService;
    public SkillController(SkillService skillService){
        this.skillService=skillService;
    }
}
