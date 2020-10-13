package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee extends BaseEntity{
    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column(unique = true)
    private String idCard;

    @Column
    private String password;

    @Column
    private Long salary;

    @Column
    private Double avgRating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Salon salon;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Employee_Role",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles;
}
