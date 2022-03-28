package project.apicapstone.dto.jobPosting;

import lombok.Data;

import project.apicapstone.entity.JobPosting;

import java.util.List;

@Data
public class PagingFormatJobPostingDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<JobPosting> records;
}
