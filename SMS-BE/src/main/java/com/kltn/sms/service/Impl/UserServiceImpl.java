package com.kltn.sms.service.Impl;

import com.kltn.sms.model.Employee;
import com.kltn.sms.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String idCard) {
        Optional<Employee> employee = employeeRepository.findByIdCard(idCard);
        if(employee.isPresent()) {
            return new CustomUserDetails(employee.get());
        }
        throw new UsernameNotFoundException(idCard);
    }

    public UserDetails loadUserById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return new CustomUserDetails(employee.get());
        }
        throw new UsernameNotFoundException("Not found user with ID=" + id);
    }
}
