package project.apicapstone.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.entity.Account;


import java.util.List;
@Data
public class PagingFormatAccountDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Account> records;
}
