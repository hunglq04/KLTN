package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "\"right\"")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Right extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "rights")
    private List<Role> roles;
}
