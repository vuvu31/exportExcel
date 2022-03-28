package project.apicapstone.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.account.PagingFormatAccountDto;
import project.apicapstone.dto.applicant.CreateApplicantDto;
import project.apicapstone.dto.applicant.PagingFormatApplicantDto;
import project.apicapstone.dto.applicant.UpdateApplicantDto;
import project.apicapstone.entity.Applicant;
import project.apicapstone.entity.JobPosting;
import project.apicapstone.repository.ApplicantRepository;
import project.apicapstone.repository.JobPostingRepository;
import project.apicapstone.service.ApplicantService;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private ApplicantRepository applicantRepository;
    private JobPostingRepository jobPostingRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, JobPostingRepository jobPostingRepository) {
        this.applicantRepository = applicantRepository;
        this.jobPostingRepository = jobPostingRepository;
    }

    @Override
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant createApplicant(CreateApplicantDto dto) {
        Applicant newApplicant = new Applicant();
        newApplicant.setApplicantId(dto.getApplicantId());
        newApplicant.setApplicantName(dto.getApplicantName());
        newApplicant.setDateBirth(dto.getDateBirth());
        newApplicant.setAddress(dto.getAddress());
        newApplicant.setPhone(dto.getPhone());
        newApplicant.setGender(dto.getGender());
        newApplicant.setEmail(dto.getEmail());
        newApplicant.setCertification(dto.getCertification());
        newApplicant.setStatus(dto.getStatus());
        newApplicant.setResumeFile(dto.getResumeFile());
        JobPosting jobPosting = jobPostingRepository.getById(dto.getJobPostingId());
        newApplicant.setJobPosting(jobPosting);
        return applicantRepository.save(newApplicant);
    }

    @Override
    public boolean isExisted(String s) {
        return applicantRepository.existsById(s);
    }

    @Override
    public Page<Applicant> findAllApplicant(Pageable pageable) {
        return applicantRepository.findAllApplicant(pageable);
    }

    @Override
    public Object pagingFormat(Page<Applicant> applicantPage) {
        PagingFormatApplicantDto dto = new PagingFormatApplicantDto();
        dto.setPageSize(applicantPage.getSize());
        dto.setTotalRecordCount(applicantPage.getTotalElements());
        dto.setPageNumber(applicantPage.getNumber());
        dto.setRecords(applicantPage.toList());
        return dto;
    }

    @Override
    public Applicant findApplicantById(String id) {
        return applicantRepository.getById(id);
    }

    @Override
    public List<Applicant> findApplicantByNameOrId(String paramSearch) {
        return applicantRepository.findApplicantsByNameOrId(paramSearch);
    }

    @Override
    public void updateApplicant(UpdateApplicantDto dto, String applicantId) {
        Applicant applicant = applicantRepository.getById(applicantId);
        applicant.setApplicantName(dto.getApplicantName());
        applicant.setDateBirth(dto.getDateBirth());
        applicant.setAddress(dto.getAddress());
        applicant.setPhone(dto.getPhone());
        applicant.setGender(dto.getGender());
        applicant.setEmail(dto.getEmail());
        applicant.setCertification(dto.getCertification());
        applicant.setStatus(dto.getStatus());
        applicant.setResumeFile(dto.getResumeFile());
        JobPosting jobPosting = jobPostingRepository.getById(dto.getJobPostingId());
        applicant.setJobPosting(jobPosting);
        applicantRepository.save(applicant);
    }

    @Override
    public void deleteById(String id) {
        applicantRepository.deleteById(id);
    }
}
