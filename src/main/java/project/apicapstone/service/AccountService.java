package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.apicapstone.dto.account.CreateAccountDto;
import project.apicapstone.dto.account.AddRoleDto;
import project.apicapstone.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account createAccount(CreateAccountDto dto);

    Account addRole(AddRoleDto dto);

    boolean isExistedUsername(String s);

    boolean isExisted(String id);

    Page<Account> findAllAccount(Pageable pageable);

    Object pagingFormat(Page<Account> accountPage);
}
