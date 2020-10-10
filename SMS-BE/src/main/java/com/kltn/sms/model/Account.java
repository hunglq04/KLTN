package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ACCOUNT", allocationSize = 1, initialValue=100)
public class Account extends BaseEntity {
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Account_Role",
            joinColumns = { @JoinColumn(name = "account_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles;
}