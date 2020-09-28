package com.kltn.sms;

import com.kltn.sms.model.Employee;
import com.kltn.sms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            Employee admin = new Employee();
            admin.setIdCard("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            employeeRepository.save(admin);
        }
    }
}
