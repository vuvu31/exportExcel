package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.entity.Skill;
import project.apicapstone.repository.SkillRepository;
import project.apicapstone.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
    private SkillRepository skillRepository;
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository=skillRepository;
    }
}
