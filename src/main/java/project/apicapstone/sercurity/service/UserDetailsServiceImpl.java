package project.apicapstone.sercurity.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.apicapstone.common.util.ResourceBadRequestException;
import project.apicapstone.common.util.ResourceNotFoundException;
import project.apicapstone.entity.Account;
import project.apicapstone.entity.Role;
import project.apicapstone.repository.AccountRepository;
import project.apicapstone.sercurity.dto.UserDetailsDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountRepository repository;
    private final String status = "ACTIVE";

    public UserDetailsServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Account account = repository.findByUsername(username);
        Account account = repository.findByUsernameAndStatus(username, status);

//        if (account == null) {
//            //throw new ResourceBadRequestException("Username is not found");
//            throw new UsernameNotFoundException("username is not fount");
//        }
//        if (!account.getStatus().equals("ACTIVE")) {
//            //throw new UsernameNotFoundException("not active");
//            throw new ResourceBadRequestException("Account not active");
//        }
        Set<GrantedAuthority> authorities = getAuthorities(account.getRoles());
        return new UserDetailsDto(username, account.getPassword(), authorities);
    }

    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }


}
