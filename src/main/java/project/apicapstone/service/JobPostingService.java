package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.apicapstone.dto.jobPosting.CreateJobPostingDto;
import project.apicapstone.dto.jobPosting.UpdateJobPostingDto;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.JobPosting;

import java.util.List;

public interface JobPostingService {
    boolean isExisted(String s);

    void createJP(CreateJobPostingDto dto);

    List<JobPosting> findAll();

    Page<JobPosting> findAllJobPosting(Pageable pageable);

    Object pagingFormat(Page<JobPosting> jobPostingPage);

    JobPosting findJobPostingById(String id);



    void deleteById(String id);

    void updateJobPosting(UpdateJobPostingDto dto, String jobPostingId);

    List<JobPosting> findJobPostingsByIdOrDescriptionOrVacancies(String paramSearch);
}
