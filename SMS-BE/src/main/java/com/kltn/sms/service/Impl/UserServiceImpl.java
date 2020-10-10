package com.kltn.sms.service.Impl;

import com.kltn.sms.model.Account;
import com.kltn.sms.model.Employee;
import com.kltn.sms.repository.AccountRepository;
import com.kltn.sms.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String idCard) {
        Optional<Account> account = accountRepository.findByUsername(idCard);
        if(account.isPresent()) {
            return new CustomUserDetails(account.get());
        }
        throw new UsernameNotFoundException(idCard);
    }

    public UserDetails loadUserById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()) {
            return new CustomUserDetails(account.get());
        }
        throw new UsernameNotFoundException("Not found user with ID=" + id);
    }
}
