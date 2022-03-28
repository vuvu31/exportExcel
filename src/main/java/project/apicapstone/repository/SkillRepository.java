package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,String> {
}
